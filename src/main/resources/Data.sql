INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (1, false, 'FairFiled', 'Iowa', '1000 Nth 4th Street', 52555);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (2, false, 'FairField', 'Iowa', '1000 Nth 4th Street', 56739);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (3, false, 'Chicago', 'Illioni', '58 ave', 95882);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (4, false, 'Seattle', 'Washington', '78 Nth street', 78445);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (5, false, 'Dallas', 'Texas', 'th587 street', 67616);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (6, false, 'FairField', 'Iowa', '1000 Nth 4th Street', 8989);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (7, false, 'FairField', 'Iowa', '1000 Nth 4th Street', 897979);
INSERT INTO public.address (id, is_deleted, city, state, street, zip) VALUES (8, false, 'FairField', 'IOwa', '1000 Nth 4th Street', 7899);

INSERT INTO public.department (id, name) VALUES (1, 'Computer Science');
INSERT INTO public.department (id, name) VALUES (2, 'Software Engineering');
INSERT INTO public.department (id, name) VALUES (3, 'Computer Engineering');
INSERT INTO public.department (id, name) VALUES (4, 'Cyber Security');
INSERT INTO public.department (id, name) VALUES (5, 'Data Science');

INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (1, false, '2022-05-08 13:58:28.000000', true, 'user1@gmail.com', 'Abenezer ', 'Alemu', '980388383', 'abenezer');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (2, false, '2022-05-08 14:11:55.000000', true, 'user2', 'Charif', 'Kadari', '69092802', 'charif');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (3, false, '2022-08-08 14:13:56.000000', true, 'user3@gmail.com', 'Sally', 'Shanin', '1234556', 'sally');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (4, false, '2022-07-08 14:15:46.000000', true, 'user4@gmail.com', 'Laith', 'Nassar', '56698061', 'Laith');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (5, false, '2022-08-09 14:16:57.000000', true, 'user@gmail.com', 'David', 'David', '5902870', 'David');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (6, false, '2022-08-08 14:35:05.000000', true, 'faculty1@gmail.com', 'Paul', 'Orazza', '00999292', 'Paul');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (7, false, '2022-08-08 14:36:19.000000', true, 'faculty2@gmail.com', 'Rene', 'Dijong', '098772724', 'Rene');
INSERT INTO public.users (id, is_deleted, last_logged_in_at, active, email, firstname, lastname, password, username) VALUES (8, false, '2022-08-08 14:37:17.000000', true, 'faculty3@gmail.com', 'Umar', 'Tacittin', '988847', 'Umar');


INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (1, 1, 1);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (2, 2, 2);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (3, 3, 3);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (4, 4, 4);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (5, 5, 5);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (6, 5, 2);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (7, 7, 1);
INSERT INTO public.faculty (user_id, address_id, department_id) VALUES (8, 8, 4);

INSERT INTO public.student (gpa, user_id, address_id, major_id) VALUES (4, 1, 1, 1);
INSERT INTO public.student (gpa, user_id, address_id, major_id) VALUES (4, 2, 2, 2);
INSERT INTO public.student (gpa, user_id, address_id, major_id) VALUES (4, 3, 3, 3);
INSERT INTO public.student (gpa, user_id, address_id, major_id) VALUES (4, 4, 4, 4);
INSERT INTO public.student (gpa, user_id, address_id, major_id) VALUES (4, 5, 5, 5);

INSERT INTO public.comment (id, is_deleted, discription, faculty_user_id, student_user_id) VALUES (2, false, 'Comment 1', 3, 2);
INSERT INTO public.comment (id, is_deleted, discription, faculty_user_id, student_user_id) VALUES (1, false, 'comment 2', 7, 2);
INSERT INTO public.comment (id, is_deleted, discription, faculty_user_id, student_user_id) VALUES (3, false, 'Comment 3', 8, 3);


INSERT INTO public.job_advertisment (id, is_deleted, company_name, address_id, student_user_id) VALUES (1, false, 'Microsoft', 4, 1);
INSERT INTO public.job_advertisment (id, is_deleted, company_name, address_id, student_user_id) VALUES (2, false, 'Google', 5, 2);
INSERT INTO public.job_advertisment (id, is_deleted, company_name, address_id, student_user_id) VALUES (3, false, 'Meta', 3, 3);
INSERT INTO public.job_advertisment (id, is_deleted, company_name, address_id, student_user_id) VALUES (4, false, 'Netflix', 2, 4);


INSERT INTO public.job_application (id, is_deleted, job_advertisment_id, student_user_id) VALUES (1, false, 1, 2);
INSERT INTO public.job_application (id, is_deleted, job_advertisment_id, student_user_id) VALUES (2, false, 2, 1);
INSERT INTO public.job_application (id, is_deleted, job_advertisment_id, student_user_id) VALUES (3, false, 3, 3);
INSERT INTO public.job_application (id, is_deleted, job_advertisment_id, student_user_id) VALUES (4, false, 4, 5);

INSERT INTO public.job_attachment (id, is_deleted, name, url, job_advertisment_id) VALUES (1, false, 'Resume', 'https://drive.google.com/file/d/1YVd0IXLlKNun9gCPv0SOlZCRLyxSEFjw/view?usp=sharing', 1);
INSERT INTO public.job_attachment (id, is_deleted, name, url, job_advertisment_id) VALUES (2, false, 'CV', 'https://drive.google.com/file/d/1YVd0IXLlKNun9gCPv0SOlZCRLyxSEFjw/view?usp=sharing', 2);
INSERT INTO public.job_attachment (id, is_deleted, name, url, job_advertisment_id) VALUES (3, false, 'Resume', 'https://drive.google.com/file/d/1YVd0IXLlKNun9gCPv0SOlZCRLyxSEFjw/view?usp=sharing', 3);
INSERT INTO public.job_attachment (id, is_deleted, name, url, job_advertisment_id) VALUES (4, false, 'CV', 'https://drive.google.com/file/d/1MKaDAxAnCFuAXqyYfnkBxyG3hUy19yDx/view?usp=sharing', 4);


INSERT INTO public.job_experience (id, is_deleted, student_user_id) VALUES (1, false, 1);
INSERT INTO public.job_experience (id, is_deleted, student_user_id) VALUES (2, false, 2);
INSERT INTO public.job_experience (id, is_deleted, student_user_id) VALUES (3, false, 3);
INSERT INTO public.job_experience (id, is_deleted, student_user_id) VALUES (4, false, 4);
INSERT INTO public.job_experience (id, is_deleted, student_user_id) VALUES (5, false, 5);


INSERT INTO public.tag (id, is_deleted, name) VALUES (1, false, 'Java');
INSERT INTO public.tag (id, is_deleted, name) VALUES (2, false, 'C++');
INSERT INTO public.tag (id, is_deleted, name) VALUES (3, false, 'Python, Java, C++');
INSERT INTO public.tag (id, is_deleted, name) VALUES (4, false, 'Swift, Objective C');
INSERT INTO public.tag (id, is_deleted, name) VALUES (5, false, 'C#');

INSERT INTO public.job_advertisment_tags (job_advertisments_id, tags_id) VALUES (1, 5);
INSERT INTO public.job_advertisment_tags (job_advertisments_id, tags_id) VALUES (2, 1);
INSERT INTO public.job_advertisment_tags (job_advertisments_id, tags_id) VALUES (3, 3);
INSERT INTO public.job_advertisment_tags (job_advertisments_id, tags_id) VALUES (4, 1);


INSERT INTO public.job_experience_tags (job_experience_id, tags_id) VALUES (2, 1);
INSERT INTO public.job_experience_tags (job_experience_id, tags_id) VALUES (3, 2);
INSERT INTO public.job_experience_tags (job_experience_id, tags_id) VALUES (1, 3);
INSERT INTO public.job_experience_tags (job_experience_id, tags_id) VALUES (4, 4);
INSERT INTO public.job_experience_tags (job_experience_id, tags_id) VALUES (5, 4);










