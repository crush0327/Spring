package ex01.nonDI;

public class NewRecordView {
	private NewRecord record;

	public NewRecordView(int kor, int eng, int math, int com) {
		this.record = new NewRecord(kor, eng, math, com);
	}
	
	public void print() {
		System.out.println("KOR : " + record.getKor());
		System.out.println("ENG : " + record.getEng());
		System.out.println("MATH : " + record.getMath());
		System.out.println("COM : " + record.getCom());
		
		System.out.println(record.total() + " / " + record.avg());
		System.out.println(record.toString());
	}
}
