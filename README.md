# Sistema de Gestión Logística - Delim

## 📋 Descripción del Proyecto

Aplicación web desarrollada para **Delim** como solución integral de gestión logística, diseñada específicamente para satisfacer los requerimientos de trazabilidad de productos de lujo, principalmente para **Chanel**. 

El sistema permite gestionar de forma completa el inventario, pedidos de entrada y salida, ubicaciones de almacén, y control de stock en tiempo real, proporcionando una trazabilidad precisa y transparente de todos los productos gestionados.

### 🎯 Características Principales

- **Gestión de Inventario**: Control completo del stock por producto, ubicación y lote
- **Pedidos de Entrada/Salida**: Creación, edición y seguimiento de pedidos con estados pendiente/recibido/enviado
- **Importación Excel**: Carga masiva de pedidos desde archivos Excel estandarizados
- **Sistema de Roles**: Control de acceso diferenciado para Administradores y Operarios
- **Trazabilidad Completa**: Registro detallado de todos los movimientos de productos
- **Gestión de Ubicaciones**: Control de palets y reubicación de productos
- **Direcciones Jerárquicas**: Gestión de colaboradores, PDV y perfumerías

## 🏗️ Arquitectura del Sistema

### Frontend
- **Framework**: Angular 16
- **Hosting**: HostPapa (dominio corporativo de Delim)
- **Comunicación**: API REST con backend

### Backend
- **Framework**: Spring Boot 17
- **Base de Datos**: MySQL con motor InnoDB
- **Hosting**: VPS Piensa Solutions
- **ORM**: Spring Data JPA + Hibernate

## 🛠️ Requisitos del Sistema

### Versiones Requeridas
- **Java**: 17 o superior
- **Node.js**: 16.x o superior
- **npm**: 8.x o superior
- **Angular CLI**: 16.x
- **MySQL**: 8.0 o superior
- **Maven**: 3.8 o superior

### Navegadores Compatibles
- Google Chrome 110+
- Navegadores basados en Chromium
- Edge 110+

## 🚀 Instalación y Despliegue

### 1. Configuración del Entorno de Desarrollo

#### Clonar el Repositorio
```bash
git clone https://github.com/ManusHD/TFG-Manuel_Horrillo.git
cd TFG-Manuel_Horrillo
```

#### Configurar Variables de Entorno
Crear archivo `.env` en el directorio del backend o directamente poner lo siguiente en el archivo .properties:
```properties
# Base de datos
DB_HOST=localhost
DB_PORT=3306
DB_NAME=delim_logistics
DB_USERNAME=your_username
DB_PASSWORD=your_password

# Configuración de aplicación
SERVER_PORT=8080
JWT_SECRET=your_jwt_secret_key
```

### 2. Configuración de la Base de Datos

#### Crear Base de Datos
```sql
CREATE DATABASE delim_logistics CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

#### Ejecutar Scripts de Inicialización
```bash
# El backend incluye configuración automática de JPA
# Las tablas se crearán automáticamente al iniciar la aplicación
```

### 3. Configuración del Backend (Spring Boot)

#### Instalar Dependencias
```bash
cd backend
mvn clean install
```

#### Configurar application.properties
```properties
# Base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/delim_logistics
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update

# Configuración del servidor
server.port=8080
server.servlet.context-path=/api

# Configuración CORS
cors.allowed-origins=http://localhost:4200
```

#### Ejecutar Backend
```bash
mvn spring-boot:run
```

### 4. Configuración del Frontend (Angular)

#### Instalar Dependencias
```bash
cd frontend
npm install
```

#### Configurar Entorno de Desarrollo
Editar `src/environments/environment.ts`:
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
```

#### Ejecutar Frontend
```bash
ng serve
```

La aplicación estará disponible en `http://localhost:4200`

## 📦 Despliegue en Producción

### Backend (VPS)

#### 1. Preparar el Servidor
```bash
# Instalar Java 17
sudo apt update
sudo apt install openjdk-17-jdk

# Instalar MySQL
sudo apt install mysql-server
```

#### 2. Configurar Base de Datos en Producción
```sql
CREATE USER 'delim_user'@'localhost' IDENTIFIED BY 'secure_password';
CREATE DATABASE delim_logistics;
GRANT ALL PRIVILEGES ON delim_logistics.* TO 'delim_user'@'localhost';
FLUSH PRIVILEGES;
```

#### 3. Compilar y Desplegar Backend
```bash
# Generar JAR
mvn clean package -Pprod

# Copiar al servidor
scp target/delim-logistics-1.0.jar user@your-vps:/opt/delim/

# Ejecutar en servidor
java -jar /opt/delim/delim-logistics-1.0.jar --spring.profiles.active=prod
```

#### 4. Configurar Servicio Systemd
```bash
# Crear archivo de servicio
sudo nano /etc/systemd/system/delim-backend.service
```

```ini
[Unit]
Description=Delim Logistics Backend
After=mysql.service

[Service]
Type=simple
User=delim
ExecStart=/usr/bin/java -jar /opt/delim/delim-logistics-1.0.jar --spring.profiles.active=prod
Restart=always

[Install]
WantedBy=multi-user.target
```

```bash
# Habilitar e iniciar servicio
sudo systemctl enable delim-backend
sudo systemctl start delim-backend
```

### Frontend (HostPapa)

#### 1. Compilar para Producción
```bash
ng build --configuration production
```

#### 2. Configurar Entorno de Producción
Editar `src/environments/environment.prod.ts`:
```typescript
export const environment = {
  production: true,
  apiUrl: 'https://your-domain.com/api'
};
```

#### 3. Subir Archivos al Hosting
```bash
# Los archivos compilados estarán en dist/
# Subir contenido de dist/ al directorio público del hosting
```

## 🔧 Configuración Adicional

### Configuración de CORS
En el backend, configurar `WebConfig.java`:
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://your-domain.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
```

### Configuración de SSL/HTTPS
Para el VPS, configurar certificado SSL:
```bash
# Usando Let's Encrypt
sudo apt install certbot
sudo certbot --nginx -d your-domain.com
```

## 📝 Gestión del Proyecto

### Metodología
- **Framework**: SCRUM con sprints de 2 semanas
- **Gestión de Tareas**: JIRA (≈50 tareas completadas)
- **Control de Versiones**: GitHub
- **Documentación**: Reuniones quincenales con tutor

### Cronología del Desarrollo
- **Octubre 2024**: Primera toma de contacto con Delim
- **Enero 2025**: Inicio de sprints SCRUM
- **Marzo 2025**: Despliegue a producción
- **Mayo 2025**: Cierre del proyecto

## 🔒 Seguridad

### Medidas Implementadas
- Autenticación basada en tokens JWT
- Cifrado de contraseñas con BCrypt
- Protección CSRF
- Control de acceso basado en roles
- Validación de entrada en frontend y backend

## 📊 Rendimiento

### Métricas Objetivo
- **Tiempo de respuesta**: < 2 segundos
- **Usuarios concurrentes**: 3 usuarios sin degradación
- **Compatibilidad**: Chrome 110+ y navegadores Chromium

## 🐛 Solución de Problemas

### Problemas Comunes

#### Error de Conexión a Base de Datos
```bash
# Verificar que MySQL esté ejecutándose
sudo systemctl status mysql

# Verificar credenciales en application.properties
```

#### Error de CORS
```bash
# Verificar configuración de CORS en WebConfig.java
# Asegurar que la URL del frontend esté en allowedOrigins
```

#### Frontend no se conecta al Backend
```bash
# Verificar URL en environment.ts
# Verificar que el backend esté ejecutándose en el puerto correcto
```

## 📄 Licencia

Este proyecto está bajo **Licencia Propietaria**. Ver el archivo [LICENSE](LICENSE) para términos completos.

### 🔒 Derechos de Autor
- **Autor**: Manuel Horrillo
- **Año**: 2025
- **Tipo**: Trabajo de Fin de Grado
- **Cliente**: Delim S.L.

### 📚 Uso Académico
Para uso académico, educativo o de investigación, es necesario:
1. Contactar al autor previamente
2. Incluir atribución completa
3. Respetar las limitaciones establecidas

### 💼 Uso Comercial
El uso comercial está restringido exclusivamente a Delim S.L. 
Para otros usos comerciales, contactar al autor.

### 📧 Contacto para Permisos
- **Email**: [mhorrillj@alumnos.unex.es]
- **GitHub**: [@ManusHD](https://github.com/ManusHD)
- **Proyecto**: [Sistema de Gestión Logística](https://github.com/ManusHD/TFG-Manuel_Horrillo)

---
**⚖️ Todos los derechos reservados - 2025**

## 👨‍💻 Autor

**Manuel Horrillo**
- GitHub: [@ManusHD](https://github.com/ManusHD)
- Proyecto: Trabajo de Fin de Grado
- Universidad: [Tu Universidad]
- Año: 2025

---

## 📞 Soporte

Para soporte técnico o consultas sobre el proyecto, contactar a través del repositorio de GitHub o mediante los canales oficiales de Delim.
