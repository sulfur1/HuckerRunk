package AlgorithmsAndDateStructure.task19;


import java.io.*;
import java.util.*;

public class YandexTask {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
             FileWriter writer = new FileWriter("src/main/resources/output.txt")) {
            /*// List с Map количество датацентров и количество перезапусков
            List<Map<Integer, Integer>> dataCenterList = new ArrayList<>();
            // List с Map количество серверов и количество работающих
            List<Map<Integer, Integer>> serversOfDataCenterList = new ArrayList<>();*/

            // Map количество датацентров и Map количество перезапусков и количество работающих, изначально равно количеству серверов
            Map<Integer, Map<Integer, Integer>> dataCenterMap = new HashMap<>();

            String line = reader.readLine();
            String[] splits = line.trim().split(" ");
            int countDataCenter = Integer.parseInt(splits[0]);
            int countServerOfDataCenter = Integer.parseInt(splits[1]);
            int countEvents = Integer.parseInt(splits[2]);

            Map<Integer, Integer> tmp;
            for (int i = 1; i <= countDataCenter; i++) {
                tmp = new HashMap<>();
                tmp.put(0, countServerOfDataCenter);
                dataCenterMap.put(i, tmp);

            }

            String event;

            for (int i = 0; i < countEvents; i++) {
                event = reader.readLine();
                if (event == null || event.equals("")) break;
                String[] strings;
                if (event.contains("RESET")) {
                    strings = event.trim().split(" ");
                    int dataCenter = Integer.parseInt(strings[1]);

                    Map<Integer, Integer> map = dataCenterMap.get(dataCenter);;
                    int reset = map.keySet().stream().max(Integer::compare).get();
                    int newReset = reset + 1;
                    map.put(newReset, countServerOfDataCenter);
                    map.remove(reset);

                    dataCenterMap.put(dataCenter, map);

                } else if (event.contains("DISABLE")) {
                    strings = event.trim().split(" ");
                    String operation = strings[0];
                    int dataCenter = Integer.parseInt(strings[1]);
                    int numberOfServer = Integer.parseInt(strings[2]);

                    Map<Integer, Integer> map = dataCenterMap.get(dataCenter);;
                    int reset = map.keySet().stream().max(Integer::compare).get();

                    int countWorkingServer = map.get(reset);
                    if (countWorkingServer > 0) {
                        --countWorkingServer;
                        map.put(reset, countWorkingServer);
                    }
                    dataCenterMap.put(dataCenter, map);
                } else {
                    if (event.contains("GETMAX")) {
                       Integer numb = getMaxOrMin(dataCenterMap, true);

                        if (i == (countEvents - 1)) {
                            writer.write(String.valueOf(numb));
                            writer.flush();
                        } else {
                            writer.write(String.valueOf(numb));
                            writer.write(10);
                            writer.flush();
                        }


                    } else if (event.contains("GETMIN")) {
                        Integer numb = getMaxOrMin(dataCenterMap, false);

                        if (i == (countEvents - 1)) {
                            writer.write(String.valueOf(numb));
                            writer.flush();
                        } else {
                            writer.write(String.valueOf(numb));
                            writer.write(10);
                            writer.flush();
                        }
                    }
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMaxOrMin(Map<Integer, Map<Integer, Integer>> dataCenterMap, boolean isMax) {
        //Map - номер дата центра и произведение
        Map<Integer, Long> hashMap = new HashMap<>();

        for (Map.Entry<Integer, Map<Integer, Integer>> entries : dataCenterMap.entrySet()) {
            Map<Integer, Integer> tmp = entries.getValue();
            for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
                long number = (long) entry.getKey() * entry.getValue();
                hashMap.put(entries.getKey(), number);
            }
        }

        int numberOfDataCenter;

        if (isMax) {
            numberOfDataCenter = dataCenterMap.size();
            long suply = 0;
            Optional<Long> max = hashMap.values().stream().max(Long::compare);
            if (max.isPresent()) {
                suply = max.get();
            }
            for (Map.Entry<Integer, Long> map : hashMap.entrySet()) {
                if (map.getValue() == suply) {
                    if (map.getKey() < numberOfDataCenter) {
                        numberOfDataCenter = map.getKey();
                    }
                }
            }

            return numberOfDataCenter;
        } else {
            numberOfDataCenter = dataCenterMap.size();
            long suply = 0;
            Optional<Long> min = hashMap.values().stream().min(Long::compare);
            if (min.isPresent()) {
                suply = min.get();
            }
            for (Map.Entry<Integer, Long> map : hashMap.entrySet()) {
                if (map.getValue() == suply) {
                    if (map.getKey() < numberOfDataCenter) {
                        numberOfDataCenter = map.getKey();
                    }
                }
            }
            return numberOfDataCenter;
        }
    }
}
