package me.localtrash.amethyst_wand.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class AmethystWand extends Item {
	public AmethystWand(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		if (context.getWorld().isClient) {
			return ActionResult.PASS;
		}

		if (Objects.requireNonNull(context.getPlayer()).getOffHandStack().getItem() == Items.DIAMOND) {
			BlockPos pos = context.getBlockPos();
			World world = context.getWorld();
			BlockState block = world.getBlockState(pos);

			if (world.canSetBlock(pos) && block.isOf(Blocks.AMETHYST_BLOCK)) {
				world.setBlockState(pos, Blocks.AIR.getDefaultState());

				ItemStack stack = Items.DIAMOND.getDefaultStack();
				Random rand = new Random();
				stack.setCount(rand.nextInt(2) + 1);
				ItemEntity entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);

				world.spawnEntity(entity);
			}
		}

		return ActionResult.SUCCESS;
	}
}
