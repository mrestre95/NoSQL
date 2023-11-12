
# Tecnologías
**Lenguaje:** Java
>Java es un lenguaje de programación versátil y robusto que se ha utilizado ampliamente en una variedad de aplicaciones, desde desarrollo de escritorio hasta aplicaciones empresariales y sistemas integrados. Su portabilidad, seguridad y enfoque en la orientación a objetos han contribuido a su duradera popularidad.

**IDE :** IntellijIdea
> IntelliJ IDEA es una herramienta integral para el desarrollo de software que ofrece un conjunto completo de características para mejorar la productividad y facilitar la creación de aplicaciones en diversos entornos y lenguajes de programación.

**Base de datos:** MongoDb
>MongoDB es una base de datos NoSQL popular que ofrece flexibilidad en el modelado de datos, escalabilidad horizontal, y un conjunto de características que la hacen adecuada para una variedad de aplicaciones, desde proyectos pequeños hasta sistemas empresariales de gran envergadura.

**Herramientas:** Docker
>Docker simplifica el proceso de desarrollo y despliegue de aplicaciones al utilizar contenedores, proporcionando portabilidad, eficiencia de recursos y un entorno consistente en todos los niveles, desde el desarrollo hasta la producción.

**Automatizacion de Tests:** Jenkins
>Jenkins es una herramienta de automatización de código abierto que se utiliza comúnmente para la construcción, prueba y implementación continua de software. Puede integrarse fácilmente con varios sistemas de gestión de versiones, entornos de desarrollo y herramientas de prueba. Aquí hay una guía básica sobre cómo puedes usar Jenkins para la automatización de pruebas:

# Configuración e instalación
**IntellijIdea**
## Requerimientos del Sistema

Para instalar y ejecutar IntellijIdea, el ambiente de trabajo debe de cumplir al menos con los siguientes requerimientos:

**Sistema Operativo**: 
>Officially released 64-bit versions of the following:Microsoft Windows 10 1809 or later
							- Windows Server 2019 or later
							- macOS 10.15 or later
							- Any Linux distribution that supports Gnome, KDE , or Unity DE.
							- IntelliJ IDEA is not available for the Linux distributions that do not include GLIBC 2.27 or later.
							- Pre-release versions are not supported
							
**Espacio en Disco**: 
>3.5 GB 

**RAM**: 
>2 GB of free RAM

**CPU**: 
>Any modern CPU

**Monitor Resolution**: 
>1024×768

## Instalación

>1 - Download the installer .exe from the https://www.jetbrains.com/idea/download/

>2 - Run the installer and follow the wizard steps.

>3 - After you run the Toolbox App, click its icon Toolbox App icon in the notification area and select which product you want to install.

>4 - Run the installer and follow the wizard steps.

>5 - On the Installation Options step, you can configure the following:

>6 - Create a desktop shortcut for launching IntelliJ IDEA.

>7 - Add the directory with IntelliJ IDEA command-line launchers to the PATH environment variable to be able to run them from any working directory in the Command 
Prompt.

>8 - Add the Open Folder as Project action to the system context menu (when you right-click a folder).

>9 - Associate specific file extensions with IntelliJ IDEA to open them with a double click

>10 - To run IntelliJ IDEA, find it in the Windows Start menu or use the desktop shortcut. You can also run the launcher batch script or executable in the installation directory under bin.


**Docker**
## Requerimientos del Sistema

Para instalar y ejecutar Docker, el ambiente de trabajo debe de cumplir al menos con los siguientes requerimientos:

**Sistema Operativo**: 
>Windows 11 64-bit: Home or Pro version 21H2 or higher, or Enterprise or Education version 21H2 or higher - Windows 10 64-bit:We recommend Home or Pro 22H2 (build 19045) or higher, or Enterprise or Education 22H2 (build 19045) or higher - Minimum required is Home or Pro 21H2 (build 19044) or higher, or Enterprise or Education 21H2 (build 19044) or higher.
							
**RAM**: 
>4 GB 

**Hardware**: 
>Enable hardware virtualization in BIOS.

**Monitor Resolution**:
>1024×768

## Instalación

>1 - Download docker from https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?_gl=1*gg9a0x*_ga*NTUxNDMzMjU1LjE2OTk1NDU1MDU.*_ga_XJWPQMJYHQ*MTY5OTU2NTA2OS4zLjEuMTY5OTU2NTM5MS42MC4wLjA.

>2 - Double-click Docker Desktop Installer.exe to run the installer.

>3 - When prompted, ensure the Use WSL 2 instead of Hyper-V option on the Configuration page is selected or not depending on your choice of backend.

>4 - If your system only supports one of the two options, you will not be able to select which backend to use.

>5 - Follow the instructions on the installation wizard to authorize the installer and proceed with the install.

>6 - When the installation is successful, select Close to complete the installation process.

>7 - If your admin account is different to your user account, you must add the user to the docker-users group. Run Computer Management as an administrator and navigate to Local Users and Groups > Groups > docker-users. Right-click to add the user to the group. Sign out and sign back in for the changes to take effect.

# Conectar IntellijIdea con Docker

>1 - Open the intillij Idea and go to the Plugins

>2 - We must search for docker and install it

>3 - The docker plugins must be appear on Intellij Idea Services

>4 - We must connect the IDE with docker in the following way: right click on Docker and click in connect

>5 - Go to application.properties file into our project and enter the docker url where we have post the database

>6 - Run the project

# Conectar IntellijIdea con Jenkins



1. Instalación de Jenkins:

-   Descarga e instala Jenkins desde el sitio web oficial: [Jenkins.io](https://www.jenkins.io/download/).
-   Sigue las instrucciones de instalación para tu sistema operativo.

2. Configuración inicial:

-   Después de la instalación, abre Jenkins en tu navegador (por lo general, en [http://localhost:8080/](http://localhost:8080/)).
-   Sigue las instrucciones para desbloquear Jenkins y configurar el usuario administrador.

3. Instalación de plugins:

-   Instala los plugins necesarios para la integración con tu sistema de control de versiones y herramientas de prueba. Por ejemplo, puedes necesitar el plugin Git, Maven, JUnit, etc.
-   Ve a "Gestionar Jenkins" -> "Administrar complementos" y selecciona los plugins necesarios.

4. Crear un nuevo trabajo (job) de estilo libre:

-   Haz clic en "Nueva tarea" o "Nuevo trabajo" en el panel de control de Jenkins.
-   Proporciona un nombre para el trabajo y selecciona "Crear un proyecto de estilo libre".
-   Configura la fuente de código fuente desde tu sistema de control de versiones (Git, SVN, etc.).

5. Configurar la construcción:

-   En la sección de construcción, selecciona las acciones específicas para construir tu proyecto. Puede ser la ejecución de un script de compilación, la construcción con Maven, etc.

6. Configurar pruebas:

-   Después de la construcción, configura la ejecución de tus pruebas. Esto podría ser mediante la ejecución de scripts de prueba, la integración con herramientas de prueba como JUnit, TestNG, etc.

7. Programación de la ejecución:

-   Puedes programar la ejecución de tus trabajos en Jenkins en intervalos regulares o después de cada confirmación en tu sistema de control de versiones.

8. Ver resultados y notificaciones:

-   Configura Jenkins para notificar sobre los resultados de las pruebas. Puedes utilizar plugins de correo electrónico, integración con sistemas de mensajería como Slack, etc.

9. Monitoreo y ajuste:

-   Monitorea regularmente los resultados de las pruebas y ajusta la configuración según sea necesario.



# Justificación
>Utilizamos la base de datos mongodb porque consideramos que es la mejor opción para manejar el tipo de datos JSON, además que posee un esquema fijo lo que permite flexibilidad y escalabilidad en la estructura. Al tratarse de una aplicación que utiliza dirección y entendemos que esto en un futuro puede tener una escalabilidad exponencial.

# Modelo de dominio
[![Modelo-de-dominio.jpg](https://i.postimg.cc/L8MWj0D2/Modelo-de-dominio.jpg)](https://postimg.cc/2V2TDGgK)
