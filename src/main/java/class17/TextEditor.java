package class17;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

interface TextEditorPlugin {
    void onInitialize();

    void onOpenDocument(String document);

    void onSaveDocument(String document);
}

class SpellCheckerPlugin implements TextEditorPlugin {
    @Override
    public void onInitialize() {
        System.out.println("Spell Checker Plugin Initialized");
    }

    @Override
    public void onOpenDocument(String document) {
        System.out.println("Spell Checker Plugin: Checking spelling for " + document);
        // Implement spell-checking logic here
    }

    @Override
    public void onSaveDocument(String document) {
        System.out.println("Spell Checker Plugin: Saving " + document);
        // Implement saving logic here
    }
}

class SyntaxHighlighterPlugin implements TextEditorPlugin {
    @Override
    public void onInitialize() {
        System.out.println("Syntax Highlighter Plugin Initialized");
    }

    @Override
    public void onOpenDocument(String document) {
        System.out.println("Syntax Highlighter Plugin: Highlighting syntax for " + document);
        // Implement syntax highlighting logic here
    }

    @Override
    public void onSaveDocument(String document) {
        System.out.println("Syntax Highlighter Plugin: Saving " + document);
        // Implement saving logic here
    }
}

class PluginManager {
    private static final Properties pluginConfig = new Properties();

    static {
        try {
            pluginConfig.load(new FileInputStream("C:\\Users\\pares\\IdeaProjects\\Serialization\\src\\main\\java\\class17\\plugin-methods-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializePlugins() {
        for (String pluginName : pluginConfig.stringPropertyNames()) {
            String className = pluginConfig.getProperty(pluginName);

            try {
                Class<?> pluginClass = Class.forName(className);
                Object plugin = pluginClass.getDeclaredConstructor().newInstance();

                Method initializeMethod = pluginClass.getDeclaredMethod("onInitialize");
                initializeMethod.invoke(plugin);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executeOpenDocumentPlugins(String document) {
        for (String pluginName : pluginConfig.stringPropertyNames()) {
            String className = pluginConfig.getProperty(pluginName);

            try {
                Class<?> pluginClass = Class.forName(className);
                Object plugin = pluginClass.getDeclaredConstructor().newInstance();

                Method openDocumentMethod = pluginClass.getDeclaredMethod("onOpenDocument", String.class);
                openDocumentMethod.invoke(plugin, document);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executeSaveDocumentPlugins(String document) {
        for (String pluginName : pluginConfig.stringPropertyNames()) {
            String className = pluginConfig.getProperty(pluginName);

            try {
                Class<?> pluginClass = Class.forName(className);
                Object plugin = pluginClass.getDeclaredConstructor().newInstance();

                Method saveDocumentMethod = pluginClass.getDeclaredMethod("onSaveDocument", String.class);
                saveDocumentMethod.invoke(plugin, document);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TextEditor {
    public static void main(String[] args) {
        // Initialize plugins
        PluginManager.initializePlugins();

        // Simulate opening a document
        String document = "sample.txt";
        System.out.println("Opening document: " + document);
        // ... perform document loading

        // Execute plugin actions for opening a document
        PluginManager.executeOpenDocumentPlugins(document);

        // Simulate saving the document
        System.out.println("Saving document: " + document);
        // ... perform document saving

        // Execute plugin actions for saving a document
        PluginManager.executeSaveDocumentPlugins(document);
    }
}
