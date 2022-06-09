import com.fis.model.Transaction;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.apache.poi.sl.usermodel.Placeholder.DATETIME;

public class ReadTransaction {
    public static final int COLUMN_INDEX_TRANSACTION_TYPE = 0;

    public static final int COLUMN_INDEX_BANK_ACCOUNT = 1;

    public static final int COLUMN_INDEX_AMOUNT = 2;

    public static final int COLUMN_INDEX_MESSAGE = 3;

    public static final int COLUMN_INDEX_DATETIME = 4;
    public static List<Transaction> tranList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final String excelFilePath = "transaction_history.xlsx";
        final List<Transaction> trans = readExcel(excelFilePath);
        for (Transaction tran : trans) {
            System.out.println(tran);
        }
    }

    public static List<Transaction> readExcel(String excelFilePath) throws IOException {
        //List<Transaction> listTrans = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            Transaction tran = new Transaction();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_TRANSACTION_TYPE:
                        tran.setTransactionType((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_BANK_ACCOUNT:
                        tran.setBankAccount((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_AMOUNT:
                        //tran.setAmount((Integer)getCellValue(cell));
                        //Long.valueOf(variable.get("Attribute").toString())
                        tran.setAmount(new BigDecimal((double) cellValue).intValue());
                        //tran.setAmount(Double.valueOf(cellValue.toString()).intValue());
                        break;
                    case COLUMN_INDEX_MESSAGE:
                        tran.setMessage((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_DATETIME:
                        Date javaDate= DateUtil.getJavaDate((double) getCellValue(cell));
                        tran.setDateTime(javaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
// dateToConvert.toInstant()
//      .atZone(ZoneId.systemDefault())
//      .toLocalDateTime();
//                        tran.setDateTime(LocalDateTime.parse(cellValue.toString(), formatter));
                        //LocalDateTime dateTime = LocalDateTime.parse((String) getCellValue(cell), formatter);
                        break;
                    default:
                        break;
                }

            }
            //listTrans.add(tran);
            tranList.add(tran);
        }

        workbook.close();
        inputStream.close();

        return tranList;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
//            case DATETIME:
//                cellValue = cell.getDateCellValue();
//                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }
}
