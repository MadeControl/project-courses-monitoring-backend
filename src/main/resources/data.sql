INSERT INTO public."user" (user_id, banned, created, email, firstname, lastname, password, role) VALUES (100, false, '2021-06-12 19:43:43.000000', 'danya.polishchuk.2001@ukr.net', 'Daniil', 'Polishchuk', '$2y$12$KREi0TmiJYFIKf.Eoyb8BefqQ2u4OCmvm0YsAaWjSZUprEp3DogbO', 'ADMIN');
INSERT INTO public."user" (user_id, banned, created, email, firstname, lastname, password, role) VALUES (9, false, '2021-06-14 19:09:09.536000', '1danya.polishchuk.2001@ukr.net', 'Danya1', 'Polishchuk1', '$2a$12$xF21.rzJwTRWqvj8M9TV9uJfOoyCzdC0.BMm7MToadH5uMaSS1ho6', 'STUDENT');
INSERT INTO public."user" (user_id, banned, created, email, firstname, lastname, password, role) VALUES (10, false, '2021-06-14 19:09:09.536000', '2danya.polishchuk.2001@ukr.net', 'Danya2', 'Polishchuk2', '$2a$12$xF21.rzJwTRWqvj8M9TV9uJfOoyCzdC0.BMm7MToadH5uMaSS1ho6', 'STUDENT');
INSERT INTO public."user" (user_id, banned, created, email, firstname, lastname, password, role) VALUES (11, false, '2021-06-14 19:09:09.536000', '3danya.polishchuk.2001@ukr.net', 'Danya3', 'Polishchuk3', '$2a$12$xF21.rzJwTRWqvj8M9TV9uJfOoyCzdC0.BMm7MToadH5uMaSS1ho6', 'STUDENT');

INSERT INTO public."theme" (theme_id, title) VALUES (1, 'Программирование');

INSERT INTO public.course (course_id, created, finished, full_description, icon_name, preview_description, started, title, user_id, theme_id) VALUES (1, '2021-06-17 20:58:57.000000', '2021-08-17 20:59:00.000000', 'Курс ориентирован на тех людей, кто уже знаком с языком программирования Java и хотел бы углубить свои знания и изучить продвинутые темы этого языка программирования. В курсе детально и подробно объясняются важнейшие темы Java и программирования в целом, которые необходимы для работы в индустрии. После прохождения этого курса вы узнаете много нового о Java и о компьютерных науках в целом.', 'favicon.ico', 'Изучите Java на профессиональном уровне', '2021-07-17 20:59:45.000000', 'Продвинутая Java', 100, 1);

INSERT INTO public.requirement (requirement_id, number, text, course_id) VALUES (1, 1, 'Знать Java на базовом уровне', 1);

INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (1, 1206, 1, 'Spring Framework. Урок 1: Введение. Зачем изучать Spring?', 'https://www.youtube.com/embed/5ePo08sqcpk', 1);
INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (2, 1374, 2, 'Spring Framework. Урок 2: Первое приложение (IntelliJ Idea).', 'https://www.youtube.com/embed/nLCYk1ySY_U', 1);
INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (3, 737, 3, 'Spring Framework. Урок 3 [НЕОБЯЗАТЕЛЬНЫЙ]: Первое приложение (Eclipse).', 'https://www.youtube.com/embed/wJTO-wnGIDk', 1);
INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (4, 1415, 4, 'Spring Framework. Урок 4: Инверсия управления. Inversion of Control (IoC).', 'https://www.youtube.com/embed/Ns0IxBXDbWw', 1);
INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (5, 505, 5, 'Spring Framework. Урок 5: Внедрение зависимостей. Dependency Injection (DI). Введение.', 'https://www.youtube.com/embed/MjnVZgMnTT0', 1);
INSERT INTO public.video (video_id, duration, number, title, url, course_id) VALUES (6, 1156, 6, 'Spring Framework. Урок 6: Внедрение зависимостей. Dependency Injection (DI). Часть 2.', 'https://www.youtube.com/embed/dBxRmUH3Af8', 1);
