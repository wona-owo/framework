create table tbl_member(
    member_no number primary key,
    member_id varchar2(20) unique not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20) not null,
    member_email varchar2(100) unique not null,
    member_phone char(13) not null,
    member_addr varchar2(200) not null,
    member_lebel number default 3 not null,
    enroll_date date default sysdate not null
);

alter table tbl_member rename column member_lebel to member_level;
commit;

create sequence seq_member;

insert into tbl_member values
(seq_member.nextval, 'admin' ,'1234','관리자' ,'test@naver.com', '010-1234-1234' , '부천' , 1, sysdate);


commit;

create or replace procedure procedure_ins_member as
begin
    for i in 1..75 loop
        insert into tbl_member values (seq_member.nextval, 'user' || i, '1234' , '유저' || i, 'test' || i || '@naver.com',
                                        '010-1234-5678', 'addr' || i, 2, sysdate);
        end loop;
        
        commit;
end;
/


select *
    from tbl_member;


BEGIN
    PROCEDURE_INS_MEMBER;
END;
/

-----------------------------------------------------------------------------------------------------------------------------

insert into tbl_member values (seq_member.nextval, 'user77', '1234', '유저77','test77@naver,com', '010-1234-1234', '서울 강남구 삼성동', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user78', '1234', '유저78','test78@naver,com', '010-1234-1234', '경기 가평군', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user79', '1234', '유저79','test79@naver,com', '010-1234-1234', '부산광역시 금정구', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user80', '1234', '유저80','test80@naver,com', '010-1234-1234', '전라남도 목포시', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user81', '1234', '유저81','test81@naver,com', '010-1234-1234', '서울 강서구 화곡동', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user82', '1234', '유저82','test82@naver,com', '010-1234-1234', '부산광역시 해운대구', 2, sysdate);
insert into tbl_member values (seq_member.nextval, 'user83', '1234', '유저83','test83@naver,com', '010-1234-1234', '경기 성남시 분당구', 2, sysdate);
commit;

create table tbl_level (
    level_code number primary key,
    level_name varchar2(20)
);

insert into tbl_level values(1, '관리자');
insert into tbl_level values(2, '정회원');
insert into tbl_level values(3, '준회원');
---------------------------------------------------------------------------------------------------------------------------

create table tbl_board (
    board_no number primary key,
    board_title varchar2(100) not null,
    board_content varchar2(2000) not null,
    board_writer number references tbl_member (member_no) on delete cascade,
    read_count number default 0,
    reg_date date default sysdate
);


create sequence seq_board;

create or replace procedure tbl_board_ins_procedure as
begin
        for i in 1..153 loop
            insert into tbl_board values (seq_board.nextval, 'title'||i, 'content'||i, 1, default, default);
        end loop;
        commit;
end;
/
begin
    tbl_board_ins_procedure;
end;
/
