-- Proyecto: Cineplanetplus  
-- Sistema : Cineplanetplus
-- Autor   : Alex
-- Fecha   : 13/04/2011
-- Objetivo: Dumping data

-- TABLA OPCION
insert into opcion(id,descripcion,estado) 
values('01','Mantenimiento','A');
insert into opcion(id,descripcion,estado) 
values('02','Consulta','A');
insert into opcion(id,descripcion,estado) 
values('03','Cartelera','A');
insert into opcion(id,descripcion,estado) 
values('04','Reportes','Activo');
insert into opcion(id,descripcion,estado) 
values('05','Reservacion','Activo');

-- TABLA PERFIL
--insert into perfil(id,nombre,estado,vigencia) 
--values('01','Administrador','Activo','2012-01-01');
insert into perfil(id,nombre,estado,vigencia) 
values('P01','Administrador','A','2012-01-01');
insert into perfil(id,nombre,estado,vigencia) 
values('P02','Usuario','A','2012-01-01');
insert into perfil(id,nombre,estado,vigencia) 
values('P03','Invitado','A','2012-01-01');

-- TABLA OPCIONPERFIL
insert into opcionperfil(idPerfil,idOpcion) 
values('P01','01');
insert into opcionperfil(idPerfil,idOpcion) 
values('P01','02');
insert into opcionperfil(idPerfil,idOpcion) 
values('P01','03');
insert into opcionperfil(idPerfil,idOpcion) 
values('P01','04');
insert into opcionperfil(idPerfil,idOpcion) 
values('P01','05');

insert into opcionperfil(idPerfil,idOpcion) 
values('P02','01');
insert into opcionperfil(idPerfil,idOpcion) 
values('P02','02');
insert into opcionperfil(idPerfil,idOpcion) 
values('P02','03');

insert into opcionperfil(idPerfil,idOpcion) 
values('P03','03');

-- TABLA USUARIO
-- usuarios
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil) 
values('USU00000001','Alex','Sanz','Arq','asanz', '1234', 'Direccion 1','A','P01');

insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil) 
values('USU00000002','Jose','Viklan','Mata','jvillanes', '1234', 'Direccion 2','A','P01');

insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000003','Carlos','Vega','Mata','cvega', '1234', 'Direccion 3','A','P02');

insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000004','Roger','Chacon','Jan','rchacon', '1234', 'Direccion 3','A','P02');

insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000005','Diana','Salas','Mata','dsalas', '1234', 'Direccion 3','A','P02');

insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000006','Jorge','Mesones','Marin','jmesones', '1234', 'Direccion 3','A','P03');
-- clientes
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000007','Ricardo','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000008','Ricardo','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000009','Carlos','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000010','Juan','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000011','Hugo','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000012','Sara','Maravi','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000013','Sofia','Franco','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000014','Leslie','Stwart','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000015','Rosa','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000016','Maritza','Mineti','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000017','Leysi','Suarez','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000018','Miguel','Cordova','Marin','rgarcia', '1234', 'Direccion 3','A',null);
insert into usuario(idUsuario,nombre,apePaterno,apeMaterno,username, passw, direccion,estado,idPerfil)  
values('USU00000019','Rafael','Garcia','Marin','rgarcia', '1234', 'Direccion 3','A',null);

-- TABLA CINE

insert into cine(idCine,nombre,direccion,telefono) 
values('C01','Cineplanet Risso', 'Direccion 1','12345678');

insert into cine(idCine,nombre,direccion,telefono) 
values('C02','Cineplanet Royal', 'Direccion 2','12345678');

insert into cine(idCine,nombre,direccion,telefono) 
values('C03','Cineplanet Larco Mar', 'Direccion 3','12345678');

insert into cine(idCine,nombre,direccion,telefono) 
values('C04','Cineplanet Alcazar', 'Direccion 4','12345678');

-- TABLA SALA

insert into sala(idSala,idCine,descripcion,aforo) 
values('S01','C01', 'Sala 1',100);

insert into sala(idSala,idCine,descripcion,aforo) 
values('S02','C01', 'Sala 2',80);

insert into sala(idSala,idCine,descripcion,aforo) 
values('S03','C01', 'Sala 3',100);

insert into sala(idSala,idCine,descripcion,aforo) 
values('S04','C02', 'Sala 1',100);

insert into sala(idSala,idCine,descripcion,aforo) 
values('S05','C02', 'Sala 2',80);

insert into sala(idSala,idCine,descripcion,aforo) 
values('S06','C02', 'Sala 3',100);



-- TABLA PELICULA

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0001','El Cisne Negro', 'Drama','Nina (Natalie Portman) es bailarina en una compañía de ballet de la ciudad de Nueva York cuya vida, como todos los de su profesión, se consume totalmente con la danza. Ella vive con su obsesiva madre, ex bailarina Erica, que ejerce un control',
'www.harry.com', 'd_peliculas/fotos_cartelera/cisne_negro.jpg', 'Darren Aronofsky.', 'Natalie Portman, Mila Kunis, Vincent Cassel.',108,'Estados Unidos', 1, 'Solo Apta M 16 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0002','Invasion del Mundo', 'Accion','Durante años, casos de avistamientos de OVNI han sido documentados alrededor del mundo (Buenos Aires, Seúl, Francia, Alemania, China, etc). Pero en el 2011, lo que eran sólo avistamientos se convertirán en una terrible realidad, cuando la Tierra sea atacada por fuerzas desconocidas. Mientras...',
'www.harry.com', 'd_peliculas/fotos_cartelera/invasion_del_mundo.jpg', 'Jonathan Liebesman.', 'Aaron Eckhart, Michelle Rodriguez, Lucas Till.',116,'Estados Unidos', 1, 'Solo Apta M 13 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0003','Sanctum 3D', 'Accion','Inspirada en hechos reales. En esta producción de James Cameron, un grupo de expertos espeleólogos y submarinistas se adentra en la última zona inexplorada de la Tierra. Se tiran en paracaídas por un enorme agujero de varios kilómetros de profundidad y llegan a unas galerías subterráneas que nadie ha pisado antes que ellos.',
'www.harry.com', 'd_peliculas/fotos_cartelera/sanctum.jpg', 'Alister Grierson.', 'Rhys Wakefield, Allison Cratchley.',95,'Estados Unidos', 1, 'Solo Apta M 16 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0004','Los Ojos de Julia', 'Terror','Cuenta la historia de una mujer con una enfermedad degenerativa en la vista y que investiga el suicidio de su hermana que también padecía esta dolencia en sus ojos. La protagonista va perdido la visión al tiempo que se verá acechada por los mismos temores que tuvo su hermana antes del trágico suicidio. La obsesión de Julia por seguir los últimos pasos de su hermana la conducen a cruzarse con una amenaza misteriosa que nadie más en su entorno parece percibir.',
'www.harry.com', 'd_peliculas/fotos_cartelera/ojos_de_julia.jpg',  'Guillem Morales.', 'Belén Rueda, Lluís Homar.',112,'España', 1, 'Solo Apta M 16 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0005','Amigos con Derechos', 'Comedia','Emma (Natalie Portman) y Adam (Ashton Kutcher) son amigos de toda la vida que tienen sexo una mañana y casi logran arruinar todo. Para proteger su amistad, hacen un pacto de mantener la relación estrictamente “libre, sin ataduras”. Esto significa: sin celos, sin expectativas, sin peleas, sin flores, sin vocecitas de bebé. Significa que pueden hacer lo que quieran, cuando quieran, en el lugar que quieran, siempre y cuando no se enamoren. Pero las preguntas no tardan en aparecer - ¿Se puede tener sexo sin que el amor se interponga en el camino?, ¿puede sobrevivir la amistad?.',
'www.harry.com', 'd_peliculas/fotos_cartelera/amigos_derecho.jpg', 'Ivan Reitman.', 'Ashton Kutcher, Natalie Portman.',112,'Estados Unidos', 1, 'Solo Apta M 13 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0006','El Discurso del Rey', 'Drama','La película está basada en la historia real de la Reina de Inglaterra, el padre y su amistad con el notable inconformista Australiano Lionel Logue. The King’s Speech está protagonizada por Colin Firth, como el rey Jorge VI, que inesperadamente se convierte en rey cuando su hermano Eduardo abdica el trono. Geoffrey Rush, interpreta a Logue , el hombre que ayuda a que el Rey encuentre una voz para dirigir la nación en la guerra.',
'www.harry.com', 'd_peliculas/fotos_cartelera/discurso_rey.jpg', 'Tom Hooper.', ' Colin Firth, Geoffrey Rush, Helena Bonham Carter.',118,'Australia', 1, 'Apta todo público', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0007','Solo 3 Dias', 'Drama','Lara Brennan es arrestada por el asesinato de su jefe, con quién se sabe había tenido una fuerte discusión. Aparentemente la vieron salir de la escena del crimen y sus huellas dactilares se encontraron en el arma asesina. Su marido, John pasará los próximos',
'www.harry.com', 'd_peliculas/fotos_cartelera/solo3dias.jpg', 'Paul Haggis.', 'Russell Crowe, Elizabeth Banks, Liam Neeson.',122,'Estados Unidos', 1, 'Solo Apta M 16 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0008','El Rito', 'Terror','Un sacerdote norteamericano viaja a Italia a estudiar en un instituto especializado en exorcismo. Allí descubrirá los casos más sorprendentes de su vida.',
'www.harry.com', 'd_peliculas/fotos_cartelera/rito.jpg', 'Mikael Håfström.', 'Colin O''Donoghue, Anthony Hopkins, Ciarán Hinds.',112,'Estados Unidos', 1, 'Solo Apta M 16 años', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0009','Enredados', 'Animacion','Cuando el más buscado y encantador bandido del reino, Flynn Rider (voz original de Zachary Levi, de la serie Chuck), se esconde en una misteriosa torre, es tomado de rehén por Rapunzel (voz de Mandy Moore), una bella y vivaz adolescente con una cabellera dorada de 21 metros de largo, que está encerrada en la torre. Entonces, la singular captora, buscando el pasaporte que la saque del encierro donde ha permanecido durante años, sella un pacto con el guapo ladrón. Así es como el dúo se lanza a una travesía llena de acción, con un caballo súper-policía, un camaleón sobreprotector y una ruda pandilla de matones.',
'www.harry.com', 'd_peliculas/fotos_cartelera/enredados.jpg', 'Byron Howard, N. Greno.', 'Chayanne, Zachary Levi, Matthew Gray Gubler.',100,'Estados Unidos', 1, 'Apta todo público', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0010','Las Aventuras de Sammy', 'Animacion','Poco después de su nacimiento en una playa de California, Sammy, un tortugo marino, en su camino a zambullirse al mar, encuentra y pierde el amor de su vida: una bonita tortuguita llamada Shelly. Durante un épico viaje a través de los océanos, nuestro protagonista esquiva todos los peligros que se le presentan con la esperanza de reunirse nuevamente con ella. Junto a su mejor amigo Ray, es testigo de cómo algunos seres humanos dañan el planeta, mientras otros hacen grandes esfuerzos por preservarlo. En su aventura, Sammy batalla con pirañas, se escapa de un águila pescadora y sale a la búsqueda de un misterioso pasaje secreto. Un día, después de tantas peripecias y riesgos, encuentra a Shelly. Ella tampoco lo ha olvidado…',
'www.harry.com', 'd_peliculas/fotos_cartelera/sammy.jpg', 'Ben Stassen.', 'Melanie Griffith, Isabelle Fuhrman , Anthony Anderson.',88,'Estados Unidos', 1, 'Apta todo público', 'Subtitulada');

insert into pelicula(idPelicula,titulo,genero,synopsis,site,imagen,director,reparto,duracion,pais,estado,publico,subtitulos) 
values('PEL0011','Infierno al Volante', 'Accion','Milton es un delincuente endurecido con una última oportunidad de redención. Empeñado en frenar una sanguinaria secta que asesinó a su hija, Milton tiene tres días para impedir que sacrifiquen a su pequeña nieta en noche de luna llena. Además, deberá hacer uso de su furia para ir más allá de los límites humanos y salvar su último vínculo con la humanidad. A Milton se le úne Piper, una joven camarera sensual y astuta que le roba a su novio el V8 color cereza para ayudar a Milton. Ambos ahora se encuentran sobre la pista del carismático Jonah King y sus despiadados seguidores. King tirará a cada uno de sus fieles bajo las ruedas del turbo negro modelo ’71 para cumplir su misión y desatar el Infierno en la Tierra.',
'www.harry.com', 'd_peliculas/fotos_cartelera/infierno_volante.jpg', 'Patrick Lussier.', 'Nicolas Cage.',144,'Estados Unidos', 0, 'Solo Apta M 16 años', 'Subtitulada');

-- TABLA HORARIO

insert into horario(id,horaInicio,horaFin)
values(1,'13:00:00', '15:00:00');
insert into horario(id,horaInicio,horaFin) 
values(2,'15:00:00', '17:00:00');
insert into horario(id,horaInicio,horaFin)
values(3,'17:00:00', '19:00:00');
insert into horario(id,horaInicio,horaFin) 
values(4,'19:00:00', '21:00:00');
insert into horario(id,horaInicio,horaFin) 
values(5,'21:00:00', '23:00:00');

-- TABLA PROGRAMACIONPELICULA
-- sala=S01 de cine C01, desde='2015-02-01',hasta = '2012-02-15',diferentes peliculas en c/horario
insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000001','S01','2011-02-01','2011-02-15','PEL0001',1);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000002','S01','2011-02-01','2011-02-15','PEL0002',2);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000003','S01','2011-02-01','2011-02-15','PEL0003',3);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000004','S01','2011-02-01','2011-02-15','PEL0004',4);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000005','S01','2011-02-01','2011-02-15','PEL0004',5);

-- sala=S02 d cine 01, desde='2015-02-01',hasta = '2012-02-15',diferentes peliculas en c/horario
insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000006','S02','2011-02-01','2011-02-15','PEL0001',1);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000007','S02','2011-02-01','2011-02-15','PEL0002',2);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000008','S02','2011-02-01','2011-02-15','PEL0003',3);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000009','S02','2011-02-01','2011-02-15','PEL0004',4);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000010','S02','2011-02-01','2011-02-15','PEL0004',5);

-- sala=S04 de cine C02 , desde='2015-02-01',hasta = '2012-02-15',idPelicula = Spiderman, horario = 13 a 15
insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000011','S04','2011-02-01','2011-02-15','PEL0001',1);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000012','S04','2011-02-01','2011-02-15','PEL0002',2);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000013','S04','2011-02-01','2011-02-15','PEL0003',3);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000014','S04','2011-02-01','2011-02-15','PEL0004',4);

insert into programacionpelicula(id,idSala,fechaInicio,fechaFin,idPelicula,idHorario) 
values('PP00000015','S04','2011-02-01','2011-02-15','PEL0004',5);


-- TABLA FILAASIENTO
-- filas de la sala 01
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(1,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(2,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(3,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(4,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(5,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(6,'S01', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(7,'S01', 7);
-- filas de la sala 02
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(8,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(9,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(10,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(11,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(12,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(13,'S02', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(14,'S02', 7);
-- filas de la sala 04 (no todos tienen misma cant asientos)
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(15,'S04', 8);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(16,'S04', 8);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(17,'S04', 8);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(18,'S04', 8);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(19,'S04', 8);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(20,'S04', 7);
insert into filaasiento(idFilaAsiento,idSala,cantAsientos) 
values(21,'S04', 7);

-- RESERVACION
-- hechas el dia '2011-02-01'para dia siguiente para funcion 00000001 (d sala 01)
insert into reservacion(idReservacion,idUsuario,idProgramacionPelicula,fechaReservada,fechaReservacion,cantAsientosReservados) 
values('RE00000001','USU00000007','PP00000001','2011-02-02','2011-02-01',2);
insert into reservacion(idReservacion,idUsuario,idProgramacionPelicula,fechaReservada,fechaReservacion,cantAsientosReservados) 
values('RE00000002','USU00000008','PP00000001','2011-02-02','2011-02-01',2);
insert into reservacion(idReservacion,idUsuario,idProgramacionPelicula,fechaReservada,fechaReservacion,cantAsientosReservados) 
values('RE00000003','USU00000009','PP00000001','2011-02-02','2011-02-01',1);
insert into reservacion(idReservacion,idUsuario,idProgramacionPelicula,fechaReservada,fechaReservacion,cantAsientosReservados) 
values('RE00000004','USU00000010','PP00000001','2011-02-02','2011-02-01',3);

-- TABLA RESERVACIONFILAASIENTO
-- Detalle para reservacion RE00000001
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000001',1,1,'RE00000001','2011-02-02');
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000002',1,2,'RE00000001','2011-02-02');
-- Detalle para reservacion RE00000002
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000003',1,3,'RE00000002','2011-02-02');
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000004',1,4,'RE00000002','2011-02-02');
-- Detalle para reservacion RE00000003
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000005',1,5,'RE00000003','2011-02-02');
-- Detalle para reservacion RE00000004
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000006',1,6,'RE00000004','2011-02-02');
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000007',1,7,'RE00000004','2011-02-02');
insert into reservacionfilaasiento(idReservacionFilaAsiento,idFilaAsiento,numeroAsiento,idReservacion,fechaReservada) 
values('RFA00000008',2,1,'RE00000004','2011-02-02');

-- TABLA NOTICIA
insert into noticia(id,titular,descripcion,fecha) 
values(1,'Oferta 2x1','Nueva oferta en cine Alcazar','2011-02-01');
insert into noticia(id,titular,descripcion,fecha) 
values(2,'Los miércoles sesión doble','El Miércoles podrán verse 2 películas de estreno seguidas.','2011-02-01');
insert into noticia(id,titular,descripcion,fecha) 
values(3,'Nueva sala premium','Abierta nueva sala premium.\r\nMás grande para que disfrutes más!!!','2011-02-01');


-- TABLA COMENTARIO
