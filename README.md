# TP-Final-Redes-2021

Contributors: Pedro Bazterrica - Leandro Toloza

# Crear un modelo cliente - servidor utilizando TCP/IP Sockets a partir de los siguientes puntos:

1) Crear un servidor:
  a) Debe aceptar conexiones entrantes
  b) Usar el port number 3000
  c) Utilizar telnet para emular el lado del cliente, y realizar conexiones entrantes (Para desarrollar el lado del servidor)
  d) Recibir data en el TCP/IP socket (Utilizar telnet para emular dicho comportamiento)
  e) La data enviada debe ser texto y se debe mostrar en la consola tanto del lado del cliente como del servidor los mensajes enviados / recibidos.
  f) Utilizar una aplicación telnet de celular para mandar datos al server
  i) Utilizar el hostname en vez de la IP para mandar información
  g) Verificar que el firewall tenga en inbound rules los permisos correctos para la entrada y salida de data.
  h) El servidor debe tener la funcionalidad de poder responderle al cliente.
  i) Si el usuario presiona ‘X’, se corta la conexion. La conexión se debe poder terminar tanto del lado del cliente como del servidor.

2) Crear un cliente:
  a) Debe poder conectarse con un servidor por medio de la IP y el puerto. Dichos datos se ingresan por consola (configurables). Puede haber más de un cliente corriendo.
  b) Manejar los errores si el usuario ingresa mal la dirección IP y el puerto, y devolver un mensaje coherente.
  c) Mostrar el estado de conexión paso a paso.
  d) El cliente debe poder tanto enviar como recibir data.
  
  
#INSTRUCTIVO

- Clonar repo.
- Desde Turn Windows Features On/Off (buscador de inicio de windows), dirigirse a TELNET Client e instalar el paquete (clickear el recuadro).

- Conectarse al servidor desde CMD (--telnet [ IP del servidor ] [3000]
- /all "Mensaje" para enviar mensaje
- x + enter para salir
- /help para los comandos
