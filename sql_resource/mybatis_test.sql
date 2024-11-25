create table tbl_member(
    member_no number primary key,
    member_id varchar2(20) unique not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20) not null,
    member_email varchar2(100) unique not null,
    member_phone char(13) not null,
    member_addr varchar2(200) not null,
    member_level number default 3 not null,
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
