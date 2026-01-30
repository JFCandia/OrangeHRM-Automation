# OrangeHRM E2E Automation 🚀

Proyecto de **automatización end-to-end** desarrollado con **Selenium + Java + Cucumber (BDD)**, enfocado en la aplicación [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/).

## 🔍 ¿Qué encontrarás en este proyecto?

- ✔️ **Automatización E2E** de flujos reales de negocio.
- ✔️ **Page Object Model (POM)** aplicado de forma clara y mantenible.
- ✔️ **Escenarios BDD** legibles, parametrizados y fáciles de entender.
- ✔️ **Evidencias visuales** generadas automáticamente en cada ejecución.
- ✔️ **Reportes Allure** integrados para un análisis profesional.
- ✔️ **Pipeline CI/CD con GitHub Actions** para ejecución continua.
- ✔️ **Reporte publicado en GitHub Pages**, accesible para revisión externa.

## 📂 Estructura del proyecto
src └── test ├── java │   └── com.orangehrm.qa │       ├── pages        # Page Object Model │       ├── steps        # Step Definitions │       └── runners      # Test Runner └── resources └── features         # Archivos .feature (BDD)


## ▶️ Ejecución local

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/orangehrm-automation.git
   cd orangehrm-automation

   - Ejecutar pruebas con Maven:
mvn clean test

- Generar reporte Allure:
mvn allure:serve

📊 Reportes- Allure Report: evidencia visual de cada ejecución.
- GitHub Actions: pipeline CI/CD configurado.
- GitHub Pages: publicación automática de reportes.
🎯 ObjetivoEl objetivo no fue solo “automatizar”, sino construir un proyecto entendible, mantenible y revisable, incluso para personas que no trabajan directamente en automatización.
La idea es mostrar cómo un proyecto de QA puede ser transparente, reproducible y útil para toda la organización.👨‍💻 Autor: Juan Francisco Candia
📍 Santiago, Chile
