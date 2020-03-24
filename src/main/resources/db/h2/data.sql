INSERT INTO veterinario VALUES (1, '44411363L', 'Vicente', 		'Priego Avilés', 		'Avenida Iglesia, 56', 	'45680', 'Quero', 		'Toledo', 	'795272796', '69wrlefoms@unforgettable.com');
INSERT INTO veterinario VALUES (2, '30170382V', 'Elena', 		'Tejada Pérez', 		'Cuesta Iglesia, 27', 	'20504', 'Urretxu', 		'Gipuzkoa', '752079460', 'fo42tihrg@scientist.com');
INSERT INTO veterinario VALUES (3, '76320883Y', 'Verónica', 	'Lesmes Eseranza', 		'Vereda De España, 50', '02267', 'Ontur', 		'Albacete', '625480967', 'u6p3osvt1@teacher.com');
INSERT INTO veterinario VALUES (4, '01318902J', 'Alberto', 		'Cabello Gómez', 		'Corredera Madrid, 13', '29497', 'Benaoján', 		'Málaga', 	'668517687', 'v8ye9r855@email.com');
INSERT INTO veterinario VALUES (5, '48843671C', 'Ana María', 	'Navarro Águeda',		'Cuesta Real, 95', 		'40174', 'Sotillo', 		'Segovia', 	'749591676', '3g7sm7os54@usa.com');
INSERT INTO veterinario VALUES (6, '93939078V', 'Hugo', 		'García Castiñeira',	'Paseo Iglesia, 90', 	'40384', 'Caballar', 		'Segovia', 	'734059377', 'f8y1b2oyg@libero.it');

INSERT INTO especialidad VALUES (1, 'radiología');
INSERT INTO especialidad VALUES (2, 'cirugía');
INSERT INTO especialidad VALUES (3, 'odontología');

INSERT INTO veterinario_especialidad VALUES (2, 1);
INSERT INTO veterinario_especialidad VALUES (3, 2);
INSERT INTO veterinario_especialidad VALUES (3, 3);
INSERT INTO veterinario_especialidad VALUES (4, 2);
INSERT INTO veterinario_especialidad VALUES (5, 1);

INSERT INTO tipo VALUES (1, 'gato');
INSERT INTO tipo VALUES (2, 'perro');
INSERT INTO tipo VALUES (3, 'lagarto');
INSERT INTO tipo VALUES (4, 'serpiente');
INSERT INTO tipo VALUES (5, 'pájaro');
INSERT INTO tipo VALUES (6, 'conejo');

INSERT INTO propietario VALUES (1, 	'98259055L', 'Fermín', 			'Pozo Rojas', 			'Vereda Nueva, 48', 	'22016', 'Bielsa', 					'Huesca', 	'629751644', '6vxmb39hv@lycos.de');
INSERT INTO propietario VALUES (2, 	'70011498G', 'Judith', 			'Serra Galindo', 		'Corredera Nueva, 87',  '50418', 'Lobera De Onsella', 		'Zaragoza', '618449211', '1fjjz7lg@gmail.com');
INSERT INTO propietario VALUES (3, 	'70572726D', 'África', 			'Alcaraz Roldán', 		'Paseo Real, 2',  		'31918', 'Aberin', 					'Navarra', 	'770392872', 'ecdle9gi0r@msn.com');
INSERT INTO propietario VALUES (4, 	'67634536T', 'Esmeralda', 		'Gámez Bernal', 		'Callejón Iglesia, 15',	'49138', 'Pozuelo De Tábara', 		'Zamora', 	'696856533', '80vn5oslc@post.com');
INSERT INTO propietario VALUES (5, 	'70123795S', 'Ana Cristina',	'Tirado Vives',  		'Rambla Madrid, 45',	'02001', 'Madrigueras', 			'Albacete', '702843980', 'vxs9bk5qod@msn.co.uk');
INSERT INTO propietario VALUES (6, 	'95277046Y', 'Ramiro', 			'Lozano Gordillo',		'Carrera Nueva, 29',	'25164', 'Sidamon', 				'Lleida', 	'723528010', 'veevaxehi@libero.it');
INSERT INTO propietario VALUES (7, 	'46850396V', 'Faustino', 		'Mateos Moyano',		'Vía Iglesia, 2',		'06214', 'Fregenal De La Sierra', 	'Badajoz', 	'759338622', '1umq9ih2bl@yahoo.es');
INSERT INTO propietario VALUES (8, 	'77548752C', 'Jose Ángel', 		'Solano López',			'Ronda Horno, 76',		'40447', 'Navas De Oro', 			'Segovia', 	'762581495', 'pqwfe2d6w@post.com');
INSERT INTO propietario VALUES (9, 	'45546717R', 'Carmelo', 		'Lago Galván',			'Pasaje Mayor, 84',		'03765', 'Benidorm', 				'Alicante', '636788878', '9mn1a1dc@post.com');
INSERT INTO propietario VALUES (10, '23693867A', 'María Carmen',	'De La Fuente Medina',	'Camino De España, 89',	'25518', 'Puigverd De Lleida', 		'Lleida', 	'612549337', 'lhdxvr8s3@lycos.es');


INSERT INTO mascota VALUES (1, 'Leo', '2019-09-07', 1, 1);
INSERT INTO mascota VALUES (2, 'Basil', '2018-08-06', 6, 2);
INSERT INTO mascota VALUES (3, 'Bamba', '2017-04-17', 2, 3);
INSERT INTO mascota VALUES (4, 'Zapatilla', '2010-03-07', 2, 3);
INSERT INTO mascota VALUES (5, 'Vilma', '2019-11-30', 3, 4);
INSERT INTO mascota VALUES (6, 'Atos', '2018-01-20', 4, 5);
INSERT INTO mascota VALUES (7, 'Zeus', '2017-09-14', 1, 6);
INSERT INTO mascota VALUES (8, 'Dulce', '2016-09-04', 1, 6);
INSERT INTO mascota VALUES (9, 'Coco', '2014-08-16', 5, 7);
INSERT INTO mascota VALUES (10, 'Bigotillos', '2014-02-24', 2, 8);
INSERT INTO mascota VALUES (11, 'Jara', '2015-03-09', 5, 9);
INSERT INTO mascota VALUES (12, 'Apolo', '2017-06-24', 2, 10);
INSERT INTO mascota VALUES (13, 'Lisa', '2020-02-08', 1, 10);

INSERT INTO visita VALUES (1, 7, '2013-01-01', 'vacunado');
INSERT INTO visita VALUES (2, 8, '2013-01-02', 'sacrificado');
INSERT INTO visita VALUES (3, 8, '2013-01-03', 'castrado');
INSERT INTO visita VALUES (4, 7, '2013-01-04', 'esterilizado');
