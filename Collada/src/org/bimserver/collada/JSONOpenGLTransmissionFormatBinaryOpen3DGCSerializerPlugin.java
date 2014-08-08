package org.bimserver.collada;

import java.util.Set;

import org.bimserver.collada.Collada2GLTFThread.Collada2GLTFConfiguration;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class JSONOpenGLTransmissionFormatBinaryOpen3DGCSerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized = false;
	
	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		Collada2GLTFConfiguration configuration = new Collada2GLTFConfiguration("Open3DGC", "binary", false, false, true, false, false);
		return new OpenGLTransmissionFormatSerializer(configuration, ".json");
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		// TODO: Consolidate separate OpenGL Transformation Format convenience plugins when plugin parameters are supported in the PluginImplementation of plugin.xml. 
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "JSON data streams (base64) wrapper for OpenGL Transmission Format (glTF) with binary Open3DGC compression.";
	}

	@Override
	public String getDefaultName() {
		return "glTF with binary Open3DGC compression as JSON data streams ";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultExtension() {
		return "json";
	}

	@Override
	public String getDefaultContentType() {
		return "application/json";
	}

}
