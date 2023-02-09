INSERT INTO slots(start_time, end_time, duration)
values(8, 11, 3), (11, 13, 2), (14, 17, 3), (18, 22, 4);

INSERT INTO classrooms(code, field_of_study, level)
values('GL-1', 'GENIE LOGICIEL ', 1),
      ('GL-2', 'GENIE LOGICIEL', 2),
      ('EFREI-1', 'CPI EFREIvPARIS', 1),
      ('EFREI-2', 'CPI EFREI PARIS', 2),
      ('MCV-1', 'MARKETING COMMERCE VENTE', 1),
      ('MCV-2', 'MARKETING COMMERCE VENTE', 2),
      ('GLT-1', 'GESTION LOGISTIQUE ET TRANSPORT', 1),
      ('GLT-2', 'GESTION LOGISTIQUE ET TRANSPORT', 2),
      ('CO-1', 'COMMUNICATION DES ORGANISATIONS', 1),
      ('CO-2', 'COMMUNICATION DES ORGANISATIONS', 2),
      ('CGE-1', 'COMPTABILITE ET GEST. DES ENTR.', 1),
      ('CGE-2', 'COMPTABILITE ET GEST. DES ENTR.', 2),
      ('MSI-5', 'MANAGEMENT DES SYSTEMES INFORAMTION', 5);


INSERT INTO tutors(name, email, address, phone_number1, phone_number2)
values('M. Ali', 'bero@yahoo.cm', 'Douala Bonamoussadi', '684588656', '65589572'),
      ('M. MBarga', 'bero2@yahoo.cm', 'Douala Bonaberi', '683588656', '69589572'),
      ('Mme. Kamta', 'bero3@yahoo.cm', 'Yaoundé NGoua Ekele', '686588656', '677589572');


INSERT INTO students(registration_number, name, email, phone_number, tutor_id, classroom_id)
values('ST001', 'Onana Jackques', 'onana@yahoo.cm', '656895721', 1, 1),
      ('ST002', 'Dongmo jacques', 'dogmo@yahoo.cm', '676895721', 2, 1),
      ('ST003', 'Hamadou Ali', 'aliham@yahoo.cm', '696895721', 3, 1),
      ('ST004', 'Bero ', 'bero@yahoo.cm', '696895722', 1, 1),
      ('ST005', 'Dongmo pascal', 'dogmo2@yahoo.cm', '696895727', 2, 1),
      ('ST006', 'Sidik Onana', 'sidik@yahoo.cm', '666895729', 1, 2);

INSERT INTO absences(absence_date, justify, justification, slot_id, student_id, classroom_id)
values('2023-01-10', false, null, 3, 1, 1),
      ('2023-01-10', false, null, 2, 1, 1),
      ('2023-02-15', true, 'retrait de passport', 1, 2, 1),
      ('2023-01-20', false, null, 1, 3, 1),
      ('2023-01-20', false, null, 2, 3, 1),
      ('2023-01-20', false, null, 3, 3, 1);
