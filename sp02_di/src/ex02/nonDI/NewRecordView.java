package ex02.nonDI;

public class NewRecordView {
	
	private NewRecord record;

//	�ʿ��� ��ü�� setter �޼ҵ带 ���ؼ� ���� �޾Ƽ� ���
//	��ü�� ������ ���� �������̰� �ʿ�� ��ü�� ����
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println("KOR : " + record.getKor());
		System.out.println(record.total() + " /  " + record.avg());
		System.out.println("+++++++++++++++");
		record.disp();
		System.out.println(record);  // toString() �Լ� ȣ��
	}

	

}
