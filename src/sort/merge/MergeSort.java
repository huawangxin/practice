package src.sort.merge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * �ⲿ����ָ���Ǵ��ļ������򣬼�������ļ�¼�洢����洢���ϣ���������ļ��޷�һ��װ���ڴ棬
 * ��Ҫ���ڴ���ⲿ�洢��֮����ж����ݽ������Դﵽ��������ļ���Ŀ�ġ� �ⲿ������õ��㷨
 * �Ƕ�·�鲢���򣬼���ԭ�ļ��ֽ�ɶ���ܹ�һ����װ���ڴ�Ĳ��֣��ֱ��ÿһ���ֵ����ڴ��������
 * Ȼ�󣬶��Ѿ���������ļ����й鲢����
 * 
 * @author huawangxin
 * @date 2017��4��11�� ����1:27:33
 */
public class MergeSort {

	/** ʮ */
	private static long TEN = 10;
	/** �� */
	private static long HUNDRED = 100;
	/** ǧ */
	private static long THOUSAND = 1000;
	/** �� */
	private static long MILLION = 10000; // 1078 00:00:01 078
	/** ʮ�� */
	private static long TEN_MILLION = 100000; // 9656 00:00:09 656
	/** ���� */
	private static long HUNDRED_MILLION = 1000000; // 93733 00:01:33 733
	/** ǧ�� */
	private static long THOUSAND_MILLION = 10000000; // 970144 00:16:10 144
	/** �� */
	private static long BILLION = 100000000;
	/** ʮ�� */
	private static long TEN_BILLION = 1000000000;
	/** ���� */
	private static long HUNDRED_BILLION = 10000000000l;
	/** ǧ�� */
	private static long THOUSAND_BILLION = 100000000000l;

	private static String INPUT_FILE = "c:\\test\\input.txt";

	private static String OUTPUT_FILE = "c:\\test\\output.txt";

	/** ��ִ�С */
	private static int SPLIT_SIZE = 10 * 10000;

	private static int numSize;

	public static void main(String[] args) throws Exception {
		createDir("c:\\test");
		createFile(INPUT_FILE);
		numSize = createRandomNum(THOUSAND_MILLION);

		sortFile(INPUT_FILE);

		long beginTime = System.currentTimeMillis();
		System.out.println("begin=" + beginTime);

		// ����ļ�
		splitFile(INPUT_FILE, numSize);

		List<String> splitFilePathList = new ArrayList<String>();
		File dir = new File("c:\\test\\temp");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			splitFilePathList.add(file.getAbsolutePath());
		}
		// �ϲ��ļ�
		createFile(OUTPUT_FILE);
		mergeFile(splitFilePathList, OUTPUT_FILE);

		long endTime = System.currentTimeMillis();
		System.out.println("end=" + endTime);
		System.out.println("end-begin=" + (endTime - beginTime));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(simpleDateFormat.format(endTime - beginTime));

		// ɾ�����ļ�
		System.gc();
		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "del", "c:\\test\\temp\\*.txt" });
	}

	private static void sortFile(String path) throws Exception {
		SortedSet<Integer> set = new TreeSet<Integer>();
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String value;
		while ((value = bufferedReader.readLine()) != null) {
			set.add(Integer.parseInt(value));
		}
		bufferedReader.close();
		fileReader.close();
		createFile("c:\\test\\input����.txt");
		writeFile("c:\\test\\input����.txt", set, false);
	}

	/**
	 * ����ļ�
	 * 
	 * @param inputPath
	 * @param numSize
	 * @throws Exception
	 */
	private static void splitFile(String inputPath, int numSize) throws Exception {
		File file = new File(inputPath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		SortedSet<Integer> set = new TreeSet<Integer>();
		String str;
		createDir("c:\\test\\temp");
		if (numSize > SPLIT_SIZE) {
			int count = 1;
			int fileNum = 1;
			while ((str = bufferedReader.readLine()) != null) {
				set.add(Integer.parseInt(str));
				// ��������д�����ļ�
				if (count >= SPLIT_SIZE) {
					createFile("c:\\test\\temp\\" + fileNum + ".txt");
					writeFile("c:\\test\\temp\\" + fileNum + ".txt", set, false);
					set.clear();
					count = 0;
					fileNum++;
				}
				count++;// ��ȡ�ļ���ǰ����
			}
		}
		// ����δ�ﵽ�����д�����ļ�
		else {
			while ((str = bufferedReader.readLine()) != null) {
				set.add(Integer.parseInt(str));
			}
			createFile("c:\\test\\temp\\1.txt");
			writeFile("c:\\test\\temp\\1.txt", set, false);
		}
		if (bufferedReader != null) {
			bufferedReader.close();
		}
		if (fileReader != null) {
			fileReader.close();
		}
	}

	/**
	 * �ϲ��ļ�
	 * 
	 * <p>
	 * 1.txt��1��3��5��7��9����2.txt��6��8��9��<br/>
	 * ����1��6����treeset�� <br/>
	 * ���1��������������1.txt�ģ��ٶ���3����ʱset�е�Ԫ����6��3��<br/>
	 * ���3�����ֻ���������1.txt�ģ��ٶ���5����ʱset�е�Ԫ����6��5�� <br/>
	 * ���5�����ֻ���������1.txt�ģ��ٶ���7����ʱset�е�Ԫ����6��7�� <br/>
	 * ���6������������2.txt�ģ�����8����ʱset�е�Ԫ����8��7�� <br/>
	 * ���7������������1.txt�ģ�����9����ʱset�е�Ԫ����8��9�� <br/>
	 * ���8������������2.txt�ģ�����9����ʱset�е�Ԫ����9��9��
	 * </p>
	 * 
	 * @param splitFilePathList
	 * @param outputPath
	 * @throws Exception
	 */
	private static void mergeFile(List<String> splitFilePathList, String outputPath) throws Exception {
		// fileInfo��ӵ�set
		SortedSet<FileInfo> fileInfoSet = new TreeSet<FileInfo>(new FileInfoComparator());
		if (fileInfoSet.isEmpty()) {
			for (int i = 0; i < splitFilePathList.size(); i++) {
				File file = new File(splitFilePathList.get(i));
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				FileInfo fileInfo = new FileInfo();
				String splitFilePath = splitFilePathList.get(i);
				fileInfo.setFileNum(Integer.parseInt(
						splitFilePath.substring(splitFilePath.lastIndexOf("\\") + 1, splitFilePath.indexOf(".txt"))));// �ļ���
				fileInfo.setReader(bufferedReader);// reader����
				String value = bufferedReader.readLine();
				if (value != null) {
					fileInfo.setValue(value);// ��ǰֵ
					fileInfo.setLineNum(fileInfo.getLineNum() + 1);// ��ǰ�к�
					fileInfoSet.add(fileInfo);
				}
			}
		}

		Set<Integer> valueSet = new LinkedHashSet<Integer>();
		boolean isSplit = false;
		int count = 1;
		// ���setԪ��
		while (!fileInfoSet.isEmpty()) {
			FileInfo currentFileInfo = fileInfoSet.first();
			valueSet.add(Integer.parseInt(currentFileInfo.getValue()));
			// �������д���ļ�
			if (valueSet.size() >= SPLIT_SIZE) {
				writeFile(outputPath, valueSet, true);
				valueSet.clear();
				isSplit = true;
			}

			// clone fileInfo
			FileInfo nextFileInfo = new FileInfo();
			nextFileInfo.setFileNum(currentFileInfo.getFileNum());
			nextFileInfo.setLineNum(currentFileInfo.getLineNum());
			nextFileInfo.setValue(currentFileInfo.getValue());
			nextFileInfo.setReader(currentFileInfo.getReader());

			boolean isSuccess = nextFileInfo.readNextValue();

			// δ���ļ�ĩβ��set��fileInfo��������
			if (isSuccess) {
				if (fileInfoSet.remove(currentFileInfo)) {
					fileInfoSet.add(nextFileInfo);
				}
			}
			// �ѵ��ļ�ĩβ����set���Ƴ��fileInfo
			else {
				fileInfoSet.remove(currentFileInfo);
			}

			System.out.println("----- MergeFile:" + count++ + " -----");
			System.out.println("fileNum=" + currentFileInfo.getFileNum());
			System.out.println("lineNum=" + currentFileInfo.getLineNum());
			System.out.println("value=" + currentFileInfo.getValue());
			System.out.println("----------------------------");
		}

		// ��δ��ֹ���һ����д���ļ�
		if (valueSet.size() > 0 && valueSet.size() < SPLIT_SIZE && !isSplit) {
			writeFile(outputPath, valueSet, false);
		}
		// ���ֹ�ʣ�ಿ��д���ļ�
		else if (valueSet.size() > 0 && valueSet.size() < SPLIT_SIZE && isSplit) {
			writeFile(outputPath, valueSet, true);
		}
	}

	/**
	 * ��������
	 * 
	 * @param numSize
	 * @return
	 * @throws Exception
	 */
	private static int createRandomNum(long numSize) throws Exception {
		Set<Integer> set = new LinkedHashSet<Integer>();
		int count = 0;
		boolean isSplit = false;
		while (count < numSize) {
			int num = (int) (Math.random() * numSize + 1);
			if (set.add(num)) {
				count++;
			}
			// �������д���ļ�
			if (set.size() >= SPLIT_SIZE) {
				writeFile(INPUT_FILE, set, true);
				set.clear();
				isSplit = true;
			}
		}

		// ��δ��ֹ���һ��д���ļ�
		if (set.size() > 0 && set.size() < SPLIT_SIZE && !isSplit) {
			writeFile(INPUT_FILE, set, false);
		}
		// ���ֹ�ʣ�ಿ��д���ļ�
		else if (set.size() > 0 && set.size() < SPLIT_SIZE && isSplit) {
			writeFile(INPUT_FILE, set, true);
		}
		return count;
	}

	private static void createDir(String dirPath) {
		File dir = new File(dirPath);
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println(dir.getName() + " is create.");
			}
		}
	}

	private static void createFile(String path) throws Exception {
		File file = new File(path);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println(file.getName() + " is create.");
			}
		}
	}

	private static void writeFile(String path, Set<Integer> set, boolean isAppend) throws Exception {
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, isAppend);// �ڶ��������ʾ���Ƿ�Ϊ׷��ģ
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			bufferedWriter.write(iterator.next().toString());
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		if (bufferedWriter != null) {
			bufferedWriter.close();
		}
		if (fileWriter != null) {
			fileWriter.close();
		}
	}
}