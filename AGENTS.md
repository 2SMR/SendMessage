# Directivas para Agentes de IA - SendMessage_2

Este documento sirve como guía operativa y técnica para cualquier agente de Inteligencia Artificial que interactúe, modifique o mantenga el proyecto **SendMessage_2**.

---

## 🎯 Visión General del Proyecto

**SendMessage_2** es una aplicación Android nativa desarrollada en **Kotlin** que demuestra la comunicación y el intercambio de información estructurada entre actividades mediante `Intent`, `Bundle` y objetos serializados con la anotación `@Parcelize`.

- **Módulo Principal**: `:app` (`com.example.sendmessage_2`)
- **Estilo de UI**: Views clásicas en XML con `ConstraintLayout` y `Material Design` (`AppCompatActivity`).

---

## 🏗️ Estructura y Componentes Clave

```
app/src/main/java/com/example/sendmessage_2/
├── model/
│   ├── Message.kt         # Data class Parcelable (id, content, sender, receiver)
│   └── Person.kt          # Data class Parcelable (dni, name, surname)
├── SendMessageActivity.kt # Actividad principal para redacción y envío
└── ViewMessageActivity.kt # Actividad secundaria para recepción y despliegue
```

### Componentes de datos:
- **`Message`**: Objeto principal que implementa `Parcelable` mediante la anotación `@Parcelize`.
- **`Person`**: Objeto secundario embebido en `Message` que también implementa `@Parcelize`.

### Componentes UI y Controlador:
- **`SendMessageActivity`**: Captura la entrada del usuario mediante `EditText` (`editTextMessage`) y envía la información empaquetada en un `Bundle` hacia `ViewMessageActivity`.
- **`ViewMessageActivity`**: Extrae el objeto parcelable mediante `IntentCompat.getParcelableExtra(intent, "KEY_MESSAGE", Message::class.java)` para máxima compatibilidad con Android 13+ (API 33+).

---

## ⚙️ Especificaciones Técnicas y Entorno

- **Lenguaje**: Kotlin 2.0.21
- **Gradle Plugin (AGP)**: 8.9.1
- **Compatibilidad JVM**: JDK 17 / JVM Target 17
- **SDK**:
  - `compileSdk`: 35
  - `minSdk`: 24 (Android 7.0)
  - `targetSdk`: 35 (Android 15)
- **Generación de Documentación**: Dokka 2.0.0
  - HTML: `/documentation/html`
  - Javadoc: `/documentation/javadoc`

---

## 📝 Reglas y Estándares de Código para Agentes

1. **Idioma de la Documentación y Comentarios**:
   - Todo comentario KDoc, documentación técnica (`README.md`, `AGENTS.md`) y mensajes en commits deben redactarse en **español**.

2. **Formato KDoc Obligatorio**:
   - Todas las clases, interfaces y métodos públicos/protegidos deben contar con su bloque KDoc detallado.
   - Ejemplo de función:
     ```kotlin
     /**
      * Crea un mensaje con remitente y destinatario y lo envía a la pantalla secundaria.
      */
     private fun sendMessage() { ... }
     ```

3. **Paso de Datos e Intents**:
   - Utilizar siempre `@Parcelize` de Kotlin (`import kotlinx.parcelize.Parcelize`).
   - Para recuperar datos parcelables en actividades destino, emplear `IntentCompat.getParcelableExtra(...)` en lugar del método deprecado `getParcelableExtra(...)`.

4. **Ciclo de Vida y Depuración**:
   - Mantener los logs de `Logcat` etiquetados con la constante `TAG` de cada actividad (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`).

---

## 🛠️ Comandos de Compilación, Pruebas y Validación

| Acción | Comando |
| :--- | :--- |
| **Compilar versión Debug** | `./gradlew assembleDebug` |
| **Ejecutar Pruebas Unitarias** | `./gradlew test` |
| **Ejecutar Pruebas Instrumentadas** | `./gradlew connectedCheck` |
| **Generar Documentación HTML (Dokka)** | `./gradlew dokkaHtml` |
| **Generar Documentación Javadoc (Dokka)** | `./gradlew dokkaJavadoc` |
| **Validar README.md** | `python .opencode/skills/personalice-docs-generator/scripts/validate_readme.py README.md` |

---

## 🤖 Skills Disponibles en el Repositorio

- **`personalice-docs-generator`** (`.opencode/skills/personalice-docs-generator`):
  - Utilizada para generar KDoc estandarizado y validar la estructura de `README.md`.
