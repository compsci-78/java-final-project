INSERT INTO addresses
(line1,line2,postal_code,city,country,created_at,updated_at)
VALUES
('Addres1_Line1','Addres1_Line2','12345','Any','London',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('Addres2_Line1','Addres2_Line2','12345','Any','Paris',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('Addres3_Line1','Addres3_Line2','12345','Any','Berlin',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


INSERT INTO users
(address_id,first_name,last_name,email,password,created_at,updated_at)
VALUES
--(1,'Micheal','Jensen','micheal@gmail.com','123456',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
--(2,'John','Smith','john@gmail.com','123456',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(3,'Dave','Ames','dave@gmail.com','123456',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


INSERT INTO goals
(user_id,status,starts_at,ends_at, created_at,updated_at)
VALUES
--(1,'PENDING',(Date '2023-06-13 00:00:00'),(Date '2023-06-13 00:00:00' + interval '1 week'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
--(1,'PENDING',(Date '2023-06-14 00:00:00'),(Date '2023-06-14 00:00:00' + interval '1 week'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(1,'PENDING',(Date '2023-06-15 00:00:00'),(Date '2023-06-15 00:00:00' + interval '1 week'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


INSERT INTO workouts
(name,type,created_at,updated_at)
VALUES
('workout 1','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 2','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 3','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 4','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 5','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 6','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 7','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 8','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 9','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 10','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('workout 11','type_a',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


INSERT INTO goals_workouts
(goal_id,workout_id,status,created_at,updated_at)
VALUES
(1,1,'PENDING',CURRENT_TIMESTAMP + interval '1 minutes',CURRENT_TIMESTAMP + interval '1 days'),
(1,2,'PENDING',CURRENT_TIMESTAMP + interval '2 minutes',CURRENT_TIMESTAMP + interval '2 days'),
(1,3,'PENDING',CURRENT_TIMESTAMP + interval '3 minutes',CURRENT_TIMESTAMP + interval '3 minutes'),
(1,4,'PENDING',CURRENT_TIMESTAMP + interval '4 minutes',CURRENT_TIMESTAMP + interval '4 days');
--(2,5,'PENDING',CURRENT_TIMESTAMP + interval '5 minutes',CURRENT_TIMESTAMP + interval '5 minutes'),
--(2,6,'PENDING',CURRENT_TIMESTAMP + interval '6 minutes',CURRENT_TIMESTAMP + interval '6 days'),
--(2,7,'PENDING',CURRENT_TIMESTAMP + interval '7 minutes',CURRENT_TIMESTAMP + interval '7 days'),
--(3,8,'PENDING',CURRENT_TIMESTAMP + interval '8 minutes',CURRENT_TIMESTAMP + interval '8 days'),
--(3,9,'PENDING',CURRENT_TIMESTAMP + interval '9 minutes',CURRENT_TIMESTAMP + interval '9 days'),
--(3,10,'PENDING',CURRENT_TIMESTAMP + interval '10 minutes',CURRENT_TIMESTAMP + interval '10 days');

INSERT INTO exercises
(name,description,muscle_group,image_link,video_link,created_at,updated_at)
VALUES
('excercise_1','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_2','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_3','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_4','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_5','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_6','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_7','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_8','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_9','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_10','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_11','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_12','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_13','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_14','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_15','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_16','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_17','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_18','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_19','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('excercise_20','any','any','image_link','vedio_link',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO workouts_exercises
(workout_id,exercise_id,sets,reps,rest_mins,duration,created_at,updated_at)
VALUES
(1,1,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(1,2,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(1,3,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(2,12,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(2,13,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(3,14,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(3,15,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(4,1,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(4,6,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(4,8,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(5,5,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(6,7,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(7,8,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(8,20,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(9,19,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(10,17,3,10,3,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);



