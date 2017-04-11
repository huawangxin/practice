package src.sort.merge;

import java.io.BufferedReader;

/**
 * �ļ���Ϣ
 * @author huawangxin
 * @date 2017��4��11�� ����1:22:33
 */
public class FileInfo {

	/**
	 * �ļ���
	 */
	private int fileNum;

	/**
	 * ��ǰ�к�
	 */
	private int lineNum = 0;

	/**
	 * ��ǰֵ
	 */
	private String value;

	/**
	 * BufferedReader����
	 */
	private BufferedReader reader;

	public boolean readNextValue() throws Exception {
		String value;
		if ((value = this.reader.readLine()) != null) {
			this.value = value;
			this.lineNum++;
			return true;
		} else {
			this.reader.close();
			return false;
		}
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
}