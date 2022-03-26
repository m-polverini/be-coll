INSERT INTO t_size_wheel
(id_size_wheel, size_wheel, active)
VALUES(1, 'R17', true);

INSERT INTO t_type_engine
(id_type_engine, type_engine, active)
VALUES(1, 'hybrid', true);

INSERT INTO t_type_vehicle
(id_type_vehicle, type_vehicle, active)
VALUES(1,'city', true);

INSERT INTO t_type_wheel
(id_type_wheel, type_wheel, active)
VALUES(1, 'lega', true);

INSERT INTO t_engine
(id_engine, power, id_type_engine, active)
VALUES(1, 1500, 1, true);

INSERT INTO t_wheel
(id_wheel, id_size_wheel, id_type_wheel, active)
VALUES(1, 1, 1, true);

INSERT INTO e_vehicle
(name, prod_from, prod_to, id_type_vehicle, id_engine, id_wheel, line, id_vehicle_parent)
VALUES('Yaris', '2000', null, 1, 1, 1, null, null);

