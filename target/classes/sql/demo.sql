drop database if exists demo;
create database if not exists demo;
use demo;

set foreign_key_checks = 0;

drop table if exists student;

create table student(
	id int(7) not null auto_increment,
    first_name varchar(300) DEFAULT NULL,
    `last_name` varchar(300) DEFAULT NULL,
    cpf varchar(11) DEFAULT NULL,
    course_id int(7) DEFAULT NULL,
    primary key(id),
    KEY `fk_course_idx` (`course_id`),
	CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists course;

create table course(
	id int(7) not null auto_increment,
    `name` varchar(300) default null,
    period_id int(1) DEFAULT NULL,
    KEY `fk_period_idx` (`period_id`),
	CONSTRAINT `fk_period` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists lesson;

create table lesson(
	id int(7) not null auto_increment,
    `name` varchar(300) default null,
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists teacher;

create table teacher(
	id int(7) not null auto_increment,
    `name` varchar(300) default null,
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists period;

create table period(
	id int(1) not null auto_increment,
    period varchar(300) default null,
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists period_teacher;

create table period_teacher(
	id int(7) not null auto_increment,
    period_id int(1) default null,
    teacher_id int(7) default null,
    available boolean default true,
    KEY `fk_period_teacher_idx` (`period_id`),
	CONSTRAINT `fk_period_teacher` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
    KEY `fk_period_teacher2_idx` (`teacher_id`),
	CONSTRAINT `fk_period_teacher2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists course_lesson;

create table course_lesson(
	id int(7) not null auto_increment,
    course_id int(7) DEFAULT NULL,
    lesson_id int(7) DEFAULT NULL,
    teacher_id int(7) DEFAULT NULL,
    semester int(2) default 0 ,
    KEY `fk_coursel_idx` (`course_id`),
	CONSTRAINT `fk_coursel` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    KEY `fk_lesson_idx` (`lesson_id`),
	CONSTRAINT `fk_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
    KEY `fk_teacher_idx` (`teacher_id`),
	CONSTRAINT `fk_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

set foreign_key_checks = 1;

-- Populate Period
insert into demo.period values(1,'Manha');
insert into demo.period values(2,'Tarde');
insert into demo.period values(3,'Noite');

-- Populate Students:
insert into demo.student values(1,'Marie','J. Levy','22695203608',null);
insert into demo.student values(2,'Igor','Castro Martins','43255314321',null);
insert into demo.student values(3,'Brenda','Castro Azevedo','71334812780',null);
insert into demo.student values(4,'Luana','Pereira Barros','36848901202',null);
insert into demo.student values(5,'Paulo','Rodrigues Dias','80628951817',null);
insert into demo.student values(6,'Sofia','Cunha Barros','31069786195',null);
insert into demo.student values(7,'Gabrielle','Lima Castro','78015613680',null);
insert into demo.student values(8,'Victor','Barbosa Cardoso','69628541102',null);
insert into demo.student values(9,'André','Oliveira Goncalves','29447319637',null);
insert into demo.student values(10,'Arthur','Ferreira Silva','36263201118',null);

-- Populate Course:
insert into demo.course values (1,"Arquitetura e Urbanismo",1);
insert into demo.course values (2,"Biomedicina",2);
insert into demo.course values (3,"Ciência da Computação",3);
insert into demo.course values (4,"Ciências Contábeis",3);
insert into demo.course values (5,"Direito",2);
insert into demo.course values (6,"Educação Física",1);
insert into demo.course values (7,"Enfermagem",1);
insert into demo.course values (8,"Engenharia Civil",2);
insert into demo.course values (9,"Turismo",3);
insert into demo.course values (10,"Pedagogia",2);

-- Populate Lesson
insert into demo.lesson values(1,'Filosofia');
insert into demo.lesson values(2,'Matemática básica');
insert into demo.lesson values(3,'Inglês');
insert into demo.lesson values(4,'Banco de Dados');
insert into demo.lesson values(5,'Programação');
insert into demo.lesson values(6,'Matemática Avançada');
insert into demo.lesson values(7,'Enfermagem');
insert into demo.lesson values(8,'Nutrição');
insert into demo.lesson values(9,'Civíl');
insert into demo.lesson values(10,'Design');

-- Populate Teacher
insert into demo.teacher values (1,"Alex Melo Cunha");
insert into demo.teacher values (2,"Brenda Dias Fernandes");
insert into demo.teacher values (3,"Sarah Silva Santos");
insert into demo.teacher values (4,"Evelyn Barbosa Fernandes");
insert into demo.teacher values (5,"Carlos Gomes Goncalves");
insert into demo.teacher values (6,"Luan Azevedo Santos");
insert into demo.teacher values (7,"Nicolash Goncalves Dias");
insert into demo.teacher values (8,"Clara Correia Silva");
insert into demo.teacher values (9,"Vinícius Sousa Lima");
insert into demo.teacher values (10,"Yasmin Pereira Rocha");

-- Populate periodTeacher
insert into demo.period_teacher values(1,1,1,false);
insert into demo.period_teacher values(2,2,1,false);
insert into demo.period_teacher values(3,3,2,true);
insert into demo.period_teacher values(4,1,3,false);
insert into demo.period_teacher values(5,2,3,true);
insert into demo.period_teacher values(6,2,4,false);
insert into demo.period_teacher values(7,3,4,true);
insert into demo.period_teacher values(8,2,5,true);
insert into demo.period_teacher values(9,3,6,false);
insert into demo.period_teacher values(10,2,7,true);
insert into demo.period_teacher values(11,3,7,true);
insert into demo.period_teacher values(12,2,8,true);
insert into demo.period_teacher values(13,1,9,true);
insert into demo.period_teacher values(14,2,9,true);
insert into demo.period_teacher values(15,1,10,true);
insert into demo.period_teacher values(16,2,10,true);

-- Populate CourseLesson
insert into demo.course_lesson values(1,1,1,1,1);
insert into demo.course_lesson values(2,1,10,3,1);
insert into demo.course_lesson values(3,2,7,1,1);
insert into demo.course_lesson values(4,2,8,4,2);
insert into demo.course_lesson values(5,4,2,6,3);
insert into demo.course_lesson values(6,5,9,null,1);
insert into demo.course_lesson values(7,5,3,null,1);
insert into demo.course_lesson values(8,6,1,null,2);
insert into demo.course_lesson values(9,6,8,null,2);
insert into demo.course_lesson values(10,7,7,null,1);