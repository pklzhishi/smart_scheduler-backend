package org.example.smart_schedulerbackend.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import java.io.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
//    private static final String UPLOAD_DIRECTORY = "D:\\testfileupload";
    private static final String UPLOAD_DIRECTORY = "/opt/test/";
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 40MB
    private static final String DB_URL = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@84986730Pkl";
    private static final String INSERT_QUERY = "INSERT INTO scheduling_task (Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Class_id,Course_ascription,Credits,Classroom_name,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Course_nature,Class_school_district,External_type,Class_department_name,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned,Department_assigned,Time_assigned) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("请求不包含文件上传内容", HttpStatus.BAD_REQUEST);
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            return new ResponseEntity<>("文件大小超过限制", HttpStatus.BAD_REQUEST);
        }

        try {
            // 创建上传目录
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 保存文件
            String fileName = "scheduling_task.xls";
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return new ResponseEntity<>("文件上传成功并将数据插入数据库: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("错误: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    private static final String DB_URL = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "@84986730Pkl";
//    private static final String TABLE_NAME = "scheduling_task";
//
//    // 输出目录
//    private static final String OUTPUT_DIR = "D:\\testfileupload";
    // 新文件名
//    private static final String NEW_FILE_NAME = "scheduling_task.xlsx";
//
//    // 固定的 SQL 插入语句
//    private static final String INSERT_SQL = "INSERT INTO scheduling_task (Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Class_id,Course_ascription,Credits,Classroom_name,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Course_nature,Class_school_district,External_type,Class_department_name,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned,Department_assigned,Time_assigned) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    @PostMapping("/upload")
//    public String processXlsFile(@RequestParam("file") MultipartFile file) {
//        // 检查文件扩展名是否为 .xlsx
//        if (!file.getOriginalFilename().endsWith(".xlsx")) {
//            return "仅支持上传 .xlsx 文件";
//        }
//
//        try {
//            // 检查输出目录是否存在，不存在则创建
//            File outputDirFile = new File(OUTPUT_DIR);
//            if (!outputDirFile.exists()) {
//                outputDirFile.mkdirs();
//            }
//
//            File tempFile = File.createTempFile("temp", ".xlsx");
//            file.transferTo(tempFile);
//
//            // 重命名并保存文件
//            File outputFile = new File(OUTPUT_DIR + File.separator + NEW_FILE_NAME);
//            // 检查目标文件是否已存在，存在则删除
//            if (outputFile.exists()) {
//                outputFile.delete();
//            }
//            boolean success = tempFile.renameTo(outputFile);
//            if (!success) {
//                tempFile.delete();
//                return "文件重命名失败";
//            }
//
//            // 将 .xlsx 文件转换为 .csv 文件
//            String csvFilePath = convertXlsxToCsv(outputFile.getAbsolutePath(), OUTPUT_DIR);
//
//            // 将 CSV 文件中的信息插入到数据库中
//            insertCsvToDatabase(csvFilePath);
//
//            // 删除临时文件
//            outputFile.delete();
//            return "文件处理成功";
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//            return "文件处理失败: " + e.getMessage();
//        }
//    }
//
//    private String convertXlsxToCsv(String xlsxFilePath, String outputDir) throws IOException {
//        String csvFilePath = outputDir + File.separator + "output.csv";
//        try (FileInputStream fis = new FileInputStream(xlsxFilePath);
//             Workbook workbook = new XSSFWorkbook(fis);
//             FileWriter writer = new FileWriter(csvFilePath)) {
//
//            Sheet sheet = workbook.getSheetAt(0);
//            for (Row row : sheet) {
//                for (int i = 0; i < row.getLastCellNum(); i++) {
//                    Cell cell = row.getCell(i);
//                    if (cell != null) {
//                        switch (cell.getCellType()) {
//                            case STRING:
//                                writer.write(cell.getStringCellValue());
//                                break;
//                            case NUMERIC:
//                                if (DateUtil.isCellDateFormatted(cell)) {
//                                    writer.write(cell.getDateCellValue().toString());
//                                } else {
//                                    writer.write(String.valueOf(cell.getNumericCellValue()));
//                                }
//                                break;
//                            case BOOLEAN:
//                                writer.write(String.valueOf(cell.getBooleanCellValue()));
//                                break;
//                            default:
//                                writer.write("");
//                        }
//                    }
//                    if (i < row.getLastCellNum() - 1) {
//                        writer.write(",");
//                    }
//                }
//                writer.write("\n");
//            }
//        }
//        return csvFilePath;
//    }
//
//    private void insertCsvToDatabase(String csvFilePath) throws IOException, SQLException {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
//
//            String line;
//            // 跳过 CSV 文件的表头
//            reader.readLine();
//
//            while ((line = reader.readLine()) != null) {
//                String[] values = line.split(",");
//
//                try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
//                    for (int i = 0; i < values.length; i++) {
//                        pstmt.setString(i + 1, values[i]);
//                    }
//                    pstmt.executeUpdate();
//                }
//            }
//        }
//    }
}







//    private static final String UPLOAD_DIRECTORY = "D:\\testfileupload";
//    private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 40MB
//    private static final String DB_URL = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "@84986730Pkl";
//    private static final String INSERT_QUERY = "INSERT INTO scheduling_task (Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Class_id,Course_ascription,Credits,Classroom_name,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Course_nature,Class_school_district,External_type,Class_department_name,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned,Department_assigned,Time_assigned) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return new ResponseEntity<>("请求不包含文件上传内容", HttpStatus.BAD_REQUEST);
//        }
//        if (file.getSize() > MAX_FILE_SIZE) {
//            return new ResponseEntity<>("文件大小超过限制", HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            // 创建上传目录
//            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            // 保存文件
//            String fileName = "scheduling_task.xls";
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // 将 Excel 文件转换为 CSV 文件
//            String csvFileName = "scheduling_task.csv";
//            Path csvFilePath = uploadPath.resolve(csvFileName);
//            convertExcelToCsv(filePath, csvFilePath);
//
//            // 读取转换后的 CSV 文件并插入数据库
//            insertDataFromCsv(csvFilePath);
//
//            return new ResponseEntity<>("文件上传成功，已转换为 CSV 文件并将数据插入数据库: " + csvFileName, HttpStatus.OK);
//        } catch (IOException | SQLException e) {
//            return new ResponseEntity<>("错误: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    private void convertExcelToCsv(Path excelFilePath, Path csvFilePath) throws IOException {
//        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(excelFilePath.toFile()));
//             FileWriter writer = new FileWriter(csvFilePath.toFile())) {
//            Sheet sheet = workbook.getSheetAt(0); // 假设数据在第一个工作表中
//            for (Row row : sheet) {
//                StringBuilder line = new StringBuilder();
//                for (Cell cell : row) {
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            line.append(cell.getStringCellValue()).append(",");
//                            break;
//                        case NUMERIC:
//                            if (DateUtil.isCellDateFormatted(cell)) {
//                                line.append(cell.getDateCellValue()).append(",");
//                            } else {
//                                line.append(cell.getNumericCellValue()).append(",");
//                            }
//                            break;
//                        case BOOLEAN:
//                            line.append(cell.getBooleanCellValue()).append(",");
//                            break;
//                        default:
//                            line.append(",").append(",");
//                    }
//                }
//                line.setLength(line.length() - 1); // 移除最后一个逗号
//                line.append("\n");
//                writer.write(line.toString());
//            }
//        }
//    }
//
//    private void insertDataFromCsv(Path csvFilePath) throws IOException, SQLException {
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath.toFile()));
//             Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
//
//            String line;
//            boolean isHeader = true;
//            while ((line = br.readLine()) != null) {
//                if (isHeader) {
//                    isHeader = false;
//                    continue; // 跳过 CSV 文件的表头
//                }
//                String[] values = line.split(",");
//
//                for (int i = 0; i < values.length; i++) {
//                    String value = values[i].trim();
//                    if (value.isEmpty()) {
//                        preparedStatement.setString(i + 1, null);
//                    } else {
//                        try {
//                            // 这里简单假设日期格式为 "yyyy-MM-dd"，你可以根据实际情况修改
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                            Date date = sdf.parse(value);
//                            preparedStatement.setDate(i + 1, new java.sql.Date(date.getTime()));
//                        } catch (ParseException e) {
//                            try {
//                                double number = Double.parseDouble(value);
//                                preparedStatement.setDouble(i + 1, number);
//                            } catch (NumberFormatException nfe) {
//                                preparedStatement.setString(i + 1, value);
//                            }
//                        }
//                    }
//                }
//                preparedStatement.executeUpdate();
//            }
//        }
//    }






//    private static final String UPLOAD_DIRECTORY = "D:\\testfileupload";
//    private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 40MB
//    private static final String DB_URL = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "@84986730Pkl";
//    private static final String INSERT_QUERY = "INSERT INTO scheduling_task (Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Class_id,Course_ascription,Credits,Classroom_name,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Course_nature,Class_school_district,External_type,Class_department_name,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned,Department_assigned,Time_assigned) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return new ResponseEntity<>("请求不包含文件上传内容", HttpStatus.BAD_REQUEST);
//        }
//        if (file.getSize() > MAX_FILE_SIZE) {
//            return new ResponseEntity<>("文件大小超过限制", HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            // 创建上传目录
//            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            // 保存文件
//            String fileName = "scheduling_task.xls";
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // 读取文件并插入数据库
//            insertDataFromFile(file.getInputStream());
//
//            return new ResponseEntity<>("文件上传成功并将数据插入数据库: " + fileName, HttpStatus.OK);
//        } catch (IOException | SQLException e) {
//            return new ResponseEntity<>("错误: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    private void insertDataFromFile(InputStream inputStream) throws IOException, SQLException {
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheetAt(0); // 假设数据在第一个工作表中
//
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
//
//            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//                Row row = sheet.getRow(rowIndex);
//                if (row != null) {
//                    for (int cellIndex = 0; cellIndex < 20; cellIndex++) {
//                        Cell cell = row.getCell(cellIndex);
//                        if (cell != null) {
//                            switch (cell.getCellType()) {
//                                case STRING:
//                                    preparedStatement.setString(cellIndex + 1, cell.getStringCellValue());
//                                    break;
//                                case NUMERIC:
//                                    if (DateUtil.isCellDateFormatted(cell)) {
//                                        preparedStatement.setDate(cellIndex + 1, new java.sql.Date(cell.getDateCellValue().getTime()));
//                                    } else {
//                                        preparedStatement.setDouble(cellIndex + 1, cell.getNumericCellValue());
//                                    }
//                                    break;
//                                case BOOLEAN:
//                                    preparedStatement.setBoolean(cellIndex + 1, cell.getBooleanCellValue());
//                                    break;
//                                default:
//                                    preparedStatement.setString(cellIndex + 1, null);
//                            }
//                        } else {
//                            preparedStatement.setString(cellIndex + 1, null);
//                        }
//                    }
//                    preparedStatement.executeUpdate();
//                }
//            }
//        } finally {
//            workbook.close();
//        }
//    }