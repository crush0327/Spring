package ex04.di;

import java.util.Scanner;

public class IRecordViewImpl implements IRecordView {
	
	private IRecordImpl  record;
	
	// setter 로 주입하기
	public void setRecord(IRecordImpl record) {  // DI 적용
		this.record = record;
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("kor : ");		record.setKor(sc.nextInt());
		System.out.print("eng : ");		record.setEng(sc.nextInt());
		System.out.print("com : ");		record.setCom(sc.nextInt());
	}

	@Override
	public void print() {
		System.out.println("\n\nKor : " + record.getKor());
		System.out.println("Eng : "+ record.getEng());
		System.out.println("Com : "+ record.getCom());
		
		System.out.println("total : "+record.total() +",\tavg : "+ record.avg());
	}

}







