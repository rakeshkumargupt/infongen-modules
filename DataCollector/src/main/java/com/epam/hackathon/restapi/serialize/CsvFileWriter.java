package com.epam.hackathon.restapi.serialize;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CsvFileWriter {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "id,date,content,link,tag,type,posSent,negSen";

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

				fileWriter.append(baseDto.getContent());

				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(baseDto.getLink());

				fileWriter.append(COMMA_DELIMITER);
				String tmp=baseDto.getTag().substring(1, baseDto.getTag().length()-1);
				tmp=tmp.substring( tmp.length()-1);
				System.out.println(tmp);
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

	}

}
