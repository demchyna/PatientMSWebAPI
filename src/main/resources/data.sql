--
-- patients table data
--

INSERT INTO public.patients (id, address, birthday, country, first_name, gender, last_name, state) VALUES (2, 'Colorado Street', '1987-11-06', 'USA', 'Nick', 'MALE', 'Brown', 'Colorado');
INSERT INTO public.patients (id, address, birthday, country, first_name, gender, last_name, state) VALUES (3, 'Texas Street', '2004-03-21', 'USA', 'Sara', 'FEMALE', 'White', 'Texas');
INSERT INTO public.patients (id, address, birthday, country, first_name, gender, last_name, state) VALUES (1, 'Florida Street', '2001-08-15', 'USA', 'Mike', 'MALE', 'Green', 'Florida');

--
-- comments table data
--

INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (1, '2021-10-19 15:40:38.390000', 'Comment about Mike #1', 1);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (2, '2021-10-19 15:42:44.653000', 'Comment about Mike #2', 1);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (3, '2021-10-19 15:44:31.938000', 'Comment about Mike #3', 1);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (4, '2021-10-19 15:45:30.340000', 'Comment about Nick #1', 2);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (5, '2021-10-19 15:45:52.770000', 'Comment about Nick #2', 2);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (6, '2021-10-19 15:46:13.318000', 'Comment about Nick #3', 2);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (7, '2021-10-19 15:46:32.715000', 'Comment about Nick #4', 2);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (8, '2021-10-19 15:47:28.954000', 'Comment about Sara #1', 3);
INSERT INTO public.comments (id, created_at, text, patient_id) VALUES (9, '2021-10-19 15:47:54.898000', 'Comment about Sara #2', 3);