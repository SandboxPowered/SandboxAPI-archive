package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.client.rendering.manager.ModelManager;
import org.sandboxpowered.api.client.rendering.manager.RenderManager;
import org.sandboxpowered.api.client.rendering.manager.ShaderManager;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.internal.SandboxServiceLoader;

public interface RenderPipeline {

    static RenderPipeline getPipeline(Identity identity) throws UnsupportedRenderPipelineException {
        return SandboxServiceLoader.loadService(PipelineService.class).getPipeline(identity);
    }

    RenderManager getRenderManager();

    ModelManager getModelManager();

    ShaderManager getShaderManager();

    class UnsupportedRenderPipelineException extends RuntimeException {

    }

}