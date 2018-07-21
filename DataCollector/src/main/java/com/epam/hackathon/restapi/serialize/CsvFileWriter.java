package com.epam.hackathon.restapi.serialize;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

public class CsvFileWriter {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "id,date,content,link,tag,type,posSent,negSen";

	public static void writeFileFromMap(String fileName, Map<String, String> values) {

		Timestamp time = new Timestamp(new Date().getTime());
		fileName = fileName + "__" + time.getTime() + ".csv";

		try {
			final FileWriter fileWriter = new FileWriter(fileName);

			fileWriter.append(FILE_HEADER.toString());
			values.forEach((key, val) -> {

				try {
					fileWriter.append(NEW_LINE_SEPARATOR);

					fileWriter.append(followCVSformat(val));

					fileWriter.append(NEW_LINE_SEPARATOR);


				} catch (IOException e) {

					System.out.println("Error while flushing/closing fileWriter !!!");

					e.printStackTrace();
				}

				

			});
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception io) {
			System.err.println("io " + io);
		}

	}
	
	public static void writeFileFromMapInt(String fileName, Map<String, Integer> values) {

		Timestamp time = new Timestamp(new Date().getTime());
		fileName = fileName + "__" + time.getTime() + ".csv";

		try {
			CSVWriter csvWriter;

			csvWriter = new CSVWriter(new FileWriter(fileName));
			values.forEach((key, val) -> {

				try {

					csvWriter.writeNext(new String[] { key, val + "" });

				} catch (Exception e) {

					System.out.println("Error while flushing/closing fileWriter !!!");

					e.printStackTrace();
				}

			});
			csvWriter.close();
		} catch (Exception io) {
			System.err.println("io " + io);
		}

	}
	
	public static void writeFileFromMapFloat(String fileName, Map<String, Float> values) {	Timestamp time = new Timestamp(new Date().getTime());
	fileName = fileName + "__" + time.getTime() + ".csv";

	try {
		CSVWriter csvWriter;

		csvWriter = new CSVWriter(new FileWriter(fileName));
		values.forEach((key, val) -> {

			try {

				csvWriter.writeNext(new String[] { key, val + "" });

			} catch (Exception e) {

				System.out.println("Error while flushing/closing fileWriter !!!");

				e.printStackTrace();
			}

		});
		csvWriter.close();
	} catch (Exception io) {
		System.err.println("io " + io);
	}}
	
	
	
	

	public static void writeFile(String fileName, BaseDto baseDto) {
		{
			Timestamp time = new Timestamp(new Date().getTime());
			fileName = fileName + "__" + time.getTime() + ".csv";
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(fileName);

				fileWriter.append(FILE_HEADER.toString());

				// Add a new line separator after the header

				fileWriter.append(NEW_LINE_SEPARATOR);

				fileWriter.append(baseDto.getId());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getTime());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getContent());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getLink());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getTag());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getType());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getSenPositiveCount());

				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(baseDto.getSenNegetiveCount());
				fileWriter.append(NEW_LINE_SEPARATOR);

			} catch (Exception ecx) {
				System.out.println("Exception " + ecx);
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();

				} catch (IOException e) {

					System.out.println("Error while flushing/closing fileWriter !!!");

					e.printStackTrace();

				}

			}

		}

	}

	public static void appendFile(String fileName, List<BaseDto> allDtos) {
		FileWriter fileWriter = null;
		Timestamp time = new Timestamp(new Date().getTime());
		fileName = fileName + "__" + time.getTime() + ".csv";
		try {
			fileWriter = new FileWriter(fileName);

			fileWriter.append(FILE_HEADER.toString());

			fileWriter.append(NEW_LINE_SEPARATOR);
			for (BaseDto baseDto : allDtos) {

				fileWriter.append(NEW_LINE_SEPARATOR);

				fileWriter.append(baseDto.getId());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getTime());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(followCVSformat(baseDto.getContent()));

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getLink());

				fileWriter.append(COMMA_DELIMITER);
				String tmp = baseDto.getTag().substring(1, baseDto.getTag().length() - 1);
				tmp = tmp.substring(0, tmp.length() - 1);

				tmp = tmp.replaceAll(", ", "#");
				fileWriter.append(tmp);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getType());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getSenPositiveCount());

				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(baseDto.getSenNegetiveCount());
				fileWriter.append(NEW_LINE_SEPARATOR);

			}

		} catch (Exception ecx) {
			System.out.println("Exception " + ecx);
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {

				System.out.println("Error while flushing/closing fileWriter !!!");

				e.printStackTrace();

			}

		}
		System.out.println("file");
	}

	private static String followCVSformat(String value) {

		String result = value;
		if (result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;

	}
	
	public static void writeToCSV(String fileName, List<BaseDto> allDtos) {
		Timestamp time = new Timestamp(new Date().getTime());
		fileName = fileName + "__" + time.getTime() + ".csv";
		try {
			CSVWriter csvWriter;

			csvWriter = new CSVWriter(new FileWriter(fileName));
			for (BaseDto baseDto : allDtos) {

				String tmp = baseDto.getTag().substring(1, baseDto.getTag().length() - 1);
				tmp = tmp.substring(0, tmp.length() - 1);

				tmp = tmp.replaceAll(", ", "#");

				String sen = baseDto.getSenPositiveCount() != null ? baseDto.getSenPositiveCount()
						: baseDto.getSenNegetiveCount();
				csvWriter.writeNext(new String[] { baseDto.getId(), baseDto.getTime(),
						followCVSformat(baseDto.getContent()), baseDto.getLink(), tmp, baseDto.getType(), sen });

			}
			csvWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
