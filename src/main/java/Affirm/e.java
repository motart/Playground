package Affirm;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

//  class Spreadsheet:
//     function Spreadsheet(file_name):
//         file_name = '*.txt'

//     function filter(filter):
//         filter = List<string column_name, string comparator, string comparison>
//         e.g. ['color', '=', 'blue'] and comparator in ['=', '!=']

//         => a list of rows that match the filter criteria

// Example:
// `small_data.txt`
// color date number (column names)
// blue 2019/03/01 7  (column values, space separated)
// green 2008/09/30 1
// red 2010/10/02 1000

// sheet = Spreadsheet('small_data.txt')
// sheet.filter(['color', '=', 'blue'])
// => [
//   ['blue','2019/03/01', '7'],
// ]


class Solution {
    public static void generateRows()  throws IOException {
        System.out.println("Starting to generate file");
        FileOutputStream output_data = null;

        try {
            String[] data = {"color date number\n", "blue 2019/03/01 7\n", "green 2008/09/30 1\n", "red 2010/10/02 1000"};
            output_data = new FileOutputStream("small_data.txt");
            //  output_data.write("color date number\n".getBytes(StandardCharsets.UTF_8));
            for (int i=0; i<4; i++) {
                output_data.write(data[i].getBytes(StandardCharsets.UTF_8));
            }

        } finally {
            if (output_data != null) {output_data.close();}
        }
    }

    public static void main(String[] args) {
        try {
            generateRows();
            List<Map<String, String>> file_data = parseFile("small_data.txt");
            List<Map<String, String>> output = filter(file_data, "color", "=", "red");
            System.out.println(output);

        } catch (IOException e) {}
    }


    private static List<Map<String, String>> parseFile(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] header = br.readLine().split(" ");
        String dataRow = null;
        List<Map<String,String>> data = new ArrayList<>();
        while ((dataRow = br.readLine()) != null) {
            String[] processedData = dataRow.split(" ");
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < processedData.length; i++) {
                map.put(header[i], processedData[i]);
            }
            data.add(map);
        }
        return data;
    }

    private static List<Map<String, String>> filter(List<Map<String, String>> data, String name, String comparator, String value) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> entry : data) {
            String dataValue = entry.get(name);
            if (comparator == "=") {
                if (dataValue.equals(value)) result.add(entry);
            } else {
                if (!dataValue.equals(value)) result.add(entry);
            }
        }
        return result;
    }
}

