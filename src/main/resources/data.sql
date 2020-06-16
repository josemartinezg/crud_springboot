INSERT INTO ESTADO (ID, NOMBRE) VALUES (1, 'RENTADO');
INSERT INTO ESTADO (ID, NOMBRE) VALUES (2, 'DEVUELTO');
INSERT INTO ESTADO (ID, NOMBRE) VALUES (3, 'DEVUELTO PARCIALMENTE');

INSERT INTO FAMILIA_EQUIPO (ID, NOMBRE, DESCRIPCION) VALUES (3, 'Cable', 'A long object used to make a physical connection. ');
INSERT INTO FAMILIA_EQUIPO (ID, NOMBRE, DESCRIPCION) VALUES (2, 'Cellphone', 'Portable telephone that can make and receive calls over a radio frequency link while the user is moving within a telephone service area. ');
INSERT INTO FAMILIA_EQUIPO (ID, NOMBRE, DESCRIPCION) VALUES (1, 'Computer', 'Programmable device that stores, retrieves, and processes data. ');

INSERT INTO SUB_FAMILIA_EQUIPO (ID, NOMBRE, FAMILIAEQUIPO_ID, DESCRIPCION) VALUES (4, '1/4 Cable', 3, '1/4 Cable');
INSERT INTO SUB_FAMILIA_EQUIPO (ID, NOMBRE, FAMILIAEQUIPO_ID, DESCRIPCION) VALUES (3, 'iPhone', 2, 'Apple Cellphone');
INSERT INTO SUB_FAMILIA_EQUIPO (ID, NOMBRE, FAMILIAEQUIPO_ID, DESCRIPCION) VALUES (2, 'Samsung', 2, 'Korean Cellphone Brand');
INSERT INTO SUB_FAMILIA_EQUIPO (ID, NOMBRE, FAMILIAEQUIPO_ID, DESCRIPCION) VALUES (1, 'Laptop', 1, 'Often called a notebook, is a small, portable personal computer (PC) with a clamshell form factor, typically having a thin LCD or LED computer screen mounted');

INSERT INTO equipo (ID, CANTIDAD_EXISTENCIA, COSTO_ALQUILER_DIARIO, DESCRIPCION, MARCA, MODELO, SUBFAMILIADEEQUIPOS_ID, IMAGEN_EQUIPO) VALUES (1, 5, 800, 'High end 15inch laptop', 'Asus', 'VivoBook Pro15', 1, 'iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAilBMVEX///8uTFmr4e3q7u+aoad0hIwfQlGfqa0nR1Xy9fZmeYLu8vMjRVNtf4eFlJopS1ne5ObS2dttlqIgPkxJa3icz9w/YGyx6PR+q7dWaXSBjpWTw856pbANOUlJY24XPk2+x8o2Ul6UoaezvsLV2tylsbbI0NNljZk4WGRTdoJbcXp4iZHEy89QZXCnsgAtAAAEe0lEQVR4nO2dDXOaMBjHZdU0FITaba7thgEsrHP2+3+98eCtt3MBgyQkof+f511fPM2veX94ShYLAAAAAAAAAAAAAAAAAAAAYIfwWN36THUMe/2iJBbMb0ScRN2CdcEC/2FF3SkouO3SaYGLDsVQ2C6aNjJ5Z/wd2y6YNuLfMsGbeTTRE+mNxDCfTyMNApFLDMs5jKN/YaXEMJlPN2w6YgJD34Gh/8DQf2DoPzD0Hxj6Dwz9Z1LD+PNIrok9TGkY//g6kp9XKE5pyB6/fRrFtwcYSoChTmAIQxjKgaFOPoThJTw3DF63r/18+e654UV48HXmhsHn3kq0bchH4rzh63Ykr44b8oeLA+UFHpnzhn2FuwwMYQhDGMIQhjCEIQxhCEMYwhCGMIQhDGEIQxjC8IMZ9obFZ2DIH3708PjLf8OAx31YzdzTZKgfGCoDQxjC8GpgqAwMYQjDq4GhMjBUMDT0nzr68tq+jGSrXa7FsdxEAziWX2oAGPoPDP0Hhv4DQ/+Bof/A0H9g6D8w9B+p4fOsDGU3oV3PynAlM6SYydiwixOQx1piuGp+w+/mAIl01WEWzoGspw6zmzmQddTh/A3XszL8mK3UaB1GMkx9mI06jPLD7pxDbkrRRh3eC8nELO4NfZqFOoz2snv2i72hSrQxW0xfh1O30qYfPp1jth/KWukHGEvjGc2HscyQDmERtbE/7GREtejYAVeMNv+h7QKOJqRwDKskhi80ose174phTbEK8SIxXOzazXElHxV84aZqLXYywUWd0TzM0sPaXw5pm2OVdRxplZxWHqbDKEY5rZZkscSWVWY8CDYFmfQ8qxP7QBhLU5qGZjEYyMbRd8LqbhekGriicFo+dreu+g9AJEkNk360oS69VR4gKH9PbHR88EU9bdCkVKxUKZpXx5OVTQ9tBH2tKLgOOtbKLnPbzEvpnaIhRanZre0iD4R29fygaHjgtOO3XeSBHAcbHm0XeSA0mPInRcMn3rVWdpiX2RvWgw03tos8kPn3w3YsVZ0tvBxL2/lw9azGKvVwPqTIXVAu1SiDjtwCl6HNQqEouFzSurSwXeRhRM1eOn1TNnxrmmnWcyS6g9DxyXytbEjrdOkhxe5C4WWeKBsmvOssbVcJqWMFyoLLZdttp9u9juc03w8wfPJtzqccufh5gCGlDUqvpjjKPRs0VxDUrJnsyHc3SejGQXeDDNttfmcg1zVCNnCcWZ6WNQFzc6wJ9+XZMpMW0kHx32XtfqiZ8sPZO5V7B5wrJpj0xk7XXHA4v2EUE6I3gD0FiSyPRCfdV1mmQZooo1nR7sbxdC8yY3Ztg7caDG/XLm/1vSnqN9trHcpuYEdzl/7DnHVkHUxFSVO7jmtGHUQb2/H+tg7z0Fjegf06pOQGvs03psi3vDvtYBroWi9nnKc8TenJ3x9/v0/fv/73h/zfV/JU9mwezTs375/aFFzk5nMbstyq4aIUZjMbuCjtCja1WGTMHFmR2xZsqKtbU1RWBxkAAAAAAAAAAAAAAAAAAAAwjD/KGo7kIG3yoQAAAABJRU5ErkJggg==');
INSERT INTO cliente (ID, APELLIDO, CEDULA, NOMBRE, FOTO_PERFIL) values (0, 'Camacho', '031-0000000-1', 'Carlos', 'iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAilBMVEX///8uTFmr4e3q7u+aoad0hIwfQlGfqa0nR1Xy9fZmeYLu8vMjRVNtf4eFlJopS1ne5ObS2dttlqIgPkxJa3icz9w/YGyx6PR+q7dWaXSBjpWTw856pbANOUlJY24XPk2+x8o2Ul6UoaezvsLV2tylsbbI0NNljZk4WGRTdoJbcXp4iZHEy89QZXCnsgAtAAAEe0lEQVR4nO2dDXOaMBjHZdU0FITaba7thgEsrHP2+3+98eCtt3MBgyQkof+f511fPM2veX94ShYLAAAAAAAAAAAAAAAAAAAAYIfwWN36THUMe/2iJBbMb0ScRN2CdcEC/2FF3SkouO3SaYGLDsVQ2C6aNjJ5Z/wd2y6YNuLfMsGbeTTRE+mNxDCfTyMNApFLDMs5jKN/YaXEMJlPN2w6YgJD34Gh/8DQf2DoPzD0Hxj6Dwz9Z1LD+PNIrok9TGkY//g6kp9XKE5pyB6/fRrFtwcYSoChTmAIQxjKgaFOPoThJTw3DF63r/18+e654UV48HXmhsHn3kq0bchH4rzh63Ykr44b8oeLA+UFHpnzhn2FuwwMYQhDGMIQhjCEIQxhCEMYwhCGMIQhDGEIQxjC8IMZ9obFZ2DIH3708PjLf8OAx31YzdzTZKgfGCoDQxjC8GpgqAwMYQjDq4GhMjBUMDT0nzr68tq+jGSrXa7FsdxEAziWX2oAGPoPDP0Hhv4DQ/+Bof/A0H9g6D8w9B+p4fOsDGU3oV3PynAlM6SYydiwixOQx1piuGp+w+/mAIl01WEWzoGspw6zmzmQddTh/A3XszL8mK3UaB1GMkx9mI06jPLD7pxDbkrRRh3eC8nELO4NfZqFOoz2snv2i72hSrQxW0xfh1O30qYfPp1jth/KWukHGEvjGc2HscyQDmERtbE/7GREtejYAVeMNv+h7QKOJqRwDKskhi80ose174phTbEK8SIxXOzazXElHxV84aZqLXYywUWd0TzM0sPaXw5pm2OVdRxplZxWHqbDKEY5rZZkscSWVWY8CDYFmfQ8qxP7QBhLU5qGZjEYyMbRd8LqbhekGriicFo+dreu+g9AJEkNk360oS69VR4gKH9PbHR88EU9bdCkVKxUKZpXx5OVTQ9tBH2tKLgOOtbKLnPbzEvpnaIhRanZre0iD4R29fygaHjgtOO3XeSBHAcbHm0XeSA0mPInRcMn3rVWdpiX2RvWgw03tos8kPn3w3YsVZ0tvBxL2/lw9azGKvVwPqTIXVAu1SiDjtwCl6HNQqEouFzSurSwXeRhRM1eOn1TNnxrmmnWcyS6g9DxyXytbEjrdOkhxe5C4WWeKBsmvOssbVcJqWMFyoLLZdttp9u9juc03w8wfPJtzqccufh5gCGlDUqvpjjKPRs0VxDUrJnsyHc3SejGQXeDDNttfmcg1zVCNnCcWZ6WNQFzc6wJ9+XZMpMW0kHx32XtfqiZ8sPZO5V7B5wrJpj0xk7XXHA4v2EUE6I3gD0FiSyPRCfdV1mmQZooo1nR7sbxdC8yY3Ztg7caDG/XLm/1vSnqN9trHcpuYEdzl/7DnHVkHUxFSVO7jmtGHUQb2/H+tg7z0Fjegf06pOQGvs03psi3vDvtYBroWi9nnKc8TenJ3x9/v0/fv/73h/zfV/JU9mwezTs375/aFFzk5nMbstyq4aIUZjMbuCjtCja1WGTMHFmR2xZsqKtbU1RWBxkAAAAAAAAAAAAAAAAAAAAwjD/KGo7kIG3yoQAAAABJRU5ErkJggg==');