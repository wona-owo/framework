package kr.or.iei.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Member {
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String memberNo;
	public Member(String memberNo, String memberId, String memberPw, String memberName, String memberEmail,
			String memberAddr, int memberLevel, String memberPhone, String enrollDate, String sFlag1, String sFlag2,
			String sFlag3, String sFlag4, String sFlag5, String sFlag6, String sFlag7) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
		this.memberLevel = memberLevel;
		this.memberPhone = memberPhone;
		this.enrollDate = enrollDate;
		this.sFlag1 = sFlag1;
		this.sFlag2 = sFlag2;
		this.sFlag3 = sFlag3;
		this.sFlag4 = sFlag4;
		this.sFlag5 = sFlag5;
		this.sFlag6 = sFlag6;
		this.sFlag7 = sFlag7;
	}
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberAddr;
	private int memberLevel;
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getsFlag1() {
		return sFlag1;
	}
	public void setsFlag1(String sFlag1) {
		this.sFlag1 = sFlag1;
	}
	public String getsFlag2() {
		return sFlag2;
	}
	public void setsFlag2(String sFlag2) {
		this.sFlag2 = sFlag2;
	}
	public String getsFlag3() {
		return sFlag3;
	}
	public void setsFlag3(String sFlag3) {
		this.sFlag3 = sFlag3;
	}
	public String getsFlag4() {
		return sFlag4;
	}
	public void setsFlag4(String sFlag4) {
		this.sFlag4 = sFlag4;
	}
	public String getsFlag5() {
		return sFlag5;
	}
	public void setsFlag5(String sFlag5) {
		this.sFlag5 = sFlag5;
	}
	public String getsFlag6() {
		return sFlag6;
	}
	public void setsFlag6(String sFlag6) {
		this.sFlag6 = sFlag6;
	}
	public String getsFlag7() {
		return sFlag7;
	}
	public void setsFlag7(String sFlag7) {
		this.sFlag7 = sFlag7;
	}
	private String memberPhone;
	private String enrollDate;
	
	//Mybatis 동적 쿼리 테스트 시, 임의 플래그 변수 생성
	private String sFlag1;
	private String sFlag2;
	private String sFlag3;
	private String sFlag4;
	private String sFlag5;
	private String sFlag6;
	private String sFlag7;	
}
