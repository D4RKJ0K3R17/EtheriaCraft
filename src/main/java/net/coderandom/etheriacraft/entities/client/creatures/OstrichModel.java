package net.coderandom.etheriacraft.entities.client.creatures;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.OstrichEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OstrichModel extends GeoModel<OstrichEntity> {
    @Override
    public ResourceLocation getModelResource(OstrichEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "geo/ostrich.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OstrichEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "textures/entity/ostrich.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OstrichEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "animations/ostrich.animation.json");
    }

    @Override
    public void setCustomAnimations(OstrichEntity animatable, long instanceId, AnimationState<OstrichEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Limit pitch to [-45, 45] degrees converted to radians
            float limitedPitch = Mth.clamp(entityData.headPitch(), -45, 45) * Mth.DEG_TO_RAD;

            // Limit yaw to [-45, 45] degrees converted to radians
            float limitedYaw = Mth.clamp(entityData.netHeadYaw(), -45, 45) * Mth.DEG_TO_RAD;

            head.setRotX(limitedPitch);
            head.setRotY(limitedYaw);
        }
    }

}
