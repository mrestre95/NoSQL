
# Tecnologías
**Lenguaje:** Java
>Java es un lenguaje de programación versátil y robusto que se ha utilizado ampliamente en una variedad de aplicaciones, desde desarrollo de escritorio hasta aplicaciones empresariales y sistemas integrados. Su portabilidad, seguridad y enfoque en la orientación a objetos han contribuido a su duradera popularidad.

**IDE :** IntellijIdea
> IntelliJ IDEA es una herramienta integral para el desarrollo de software que ofrece un conjunto completo de características para mejorar la productividad y facilitar la creación de aplicaciones en diversos entornos y lenguajes de programación.

**Base de datos:** MongoDb
>MongoDB es una base de datos NoSQL popular que ofrece flexibilidad en el modelado de datos, escalabilidad horizontal, y un conjunto de características que la hacen adecuada para una variedad de aplicaciones, desde proyectos pequeños hasta sistemas empresariales de gran envergadura.

**Herramientas:** Docker
>Docker simplifica el proceso de desarrollo y despliegue de aplicaciones al utilizar contenedores, proporcionando portabilidad, eficiencia de recursos y un entorno consistente en todos los niveles, desde el desarrollo hasta la producción.

# Configuración e instalación
IntellijIdea
## Requerimientos del Sistema

-	Para instalar y ejecutar IntellijIdea, el ambiente de trabajo debe de cumplir al menos con los siguientes requerimientos:

-   **Sistema Operativo**: Officially released 64-bit versions of the following:
							- Microsoft Windows 10 1809 or later
							- Windows Server 2019 or later
							- macOS 10.15 or later
							- Any Linux distribution that supports Gnome, KDE , or Unity DE.
							- IntelliJ IDEA is not available for the Linux distributions that do not include GLIBC 2.27 or later.
							- Pre-release versions are not supported
							
-   **Espacio en Disco**: 3.5 GB 
-   **RAM**: 2 GB of free RAM
-   **CPU**: Any modern CPU
-   **Monitor Resolution**: 1024×768

## Instalación

1 - Download the installer .exe from the https://www.jetbrains.com/idea/download/

2 - Run the installer and follow the wizard steps.

3 - After you run the Toolbox App, click its icon Toolbox App icon in the notification area and select which product you want to install.

4 - Run the installer and follow the wizard steps.

5 - On the Installation Options step, you can configure the following:

6 - Create a desktop shortcut for launching IntelliJ IDEA.

7 - Add the directory with IntelliJ IDEA command-line launchers to the PATH environment variable to be able to run them from any working directory in the Command 
Prompt.

8 - Add the Open Folder as Project action to the system context menu (when you right-click a folder).

9 - Associate specific file extensions with IntelliJ IDEA to open them with a double click

10 - To run IntelliJ IDEA, find it in the Windows Start menu or use the desktop shortcut. You can also run the launcher batch script or executable in the installation directory under bin.


Docker
## Requerimientos del Sistema

-	Para instalar y ejecutar Docker, el ambiente de trabajo debe de cumplir al menos con los siguientes requerimientos:

-   **Sistema Operativo**: 
						  - Windows 11 64-bit: Home or Pro version 21H2 or higher, or Enterprise or Education version 21H2 or higher.
						  - Windows 10 64-bit:We recommend Home or Pro 22H2 (build 19045) or higher, or Enterprise or Education 22H2 (build 19045) or higher.
											  Minimum required is Home or Pro 21H2 (build 19044) or higher, or Enterprise or Education 21H2 (build 19044) or higher.
							
-   **RAM**: 4 GB 
-   **Hardware**: Enable hardware virtualization in BIOS.
-   **Monitor Resolution**: 1024×768

## Instalación

1 - Download docker from https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?_gl=1*gg9a0x*_ga*NTUxNDMzMjU1LjE2OTk1NDU1MDU.*_ga_XJWPQMJYHQ*MTY5OTU2NTA2OS4zLjEuMTY5OTU2NTM5MS42MC4wLjA.

2 - Double-click Docker Desktop Installer.exe to run the installer.

3 - When prompted, ensure the Use WSL 2 instead of Hyper-V option on the Configuration page is selected or not depending on your choice of backend.

4 - If your system only supports one of the two options, you will not be able to select which backend to use.

5 - Follow the instructions on the installation wizard to authorize the installer and proceed with the install.

6 - When the installation is successful, select Close to complete the installation process.

7 - If your admin account is different to your user account, you must add the user to the docker-users group. Run Computer Management as an administrator and navigate to Local Users and Groups > Groups > docker-users. Right-click to add the user to the group. Sign out and sign back in for the changes to take effect.

# Conectar IntellijIdea con Docker
