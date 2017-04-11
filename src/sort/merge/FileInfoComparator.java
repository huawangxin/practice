package src.sort.merge;

import java.util.Comparator;

/**
 * �ļ��Ƚ���
 * 
 * @author huawangxin
 * @date 2017��4��11�� ����1:23:30
 */
public class FileInfoComparator implements Comparator<FileInfo> {

	public int compare(FileInfo o1, FileInfo o2) {
		if (Integer.parseInt(o1.getValue()) != Integer.parseInt(o2.getValue())) {
			return Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue());
		}else {// �������ظ�ֵ��ʹ���ļ��űȽ�
			return o1.getFileNum() - o2.getFileNum();
		}
	}
}