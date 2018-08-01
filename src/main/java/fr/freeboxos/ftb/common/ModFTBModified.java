package fr.freeboxos.ftb.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.freeboxos.ftb.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ModFTBModified.MODID, name = "Mod FTB Modified", version = "1.3.0")

public class ModFTBModified {
	public static final String MODID = "modftbmodified";

	@Instance(MODID)
	public static ModFTBModified instance;

	@SidedProxy(clientSide = "fr.freeboxos.fr.proxy.ClientProxy", serverSide = "fr.freeboxos.fr.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Item ironBrut, goldBrut, netherStardust, swordemerald, pickaxeemrald, axeemerald, shovelemerald,
			hoeemerald, helmetEmerald, chestPlateEmerald, leggingsEmerald, bootsEmerald, emeraldNuggets, diamondNuggets,
			swordstar, pickaxestar, shovelstar, axestar, helmetNetherStar, chestPlateNetherStar, leggingsNetherStar, bootsNetherStar, netherStarIngot;


	public static Block ironBrutblock, goldBrutblock, emeraldBrutblock, diamondBrutblock, netherStarOre,
			netherStarBlock;

	public static ToolMaterial toolEmerald = EnumHelper.addToolMaterial("toolEmerald", 3, 10000, 60.0F, 26.0F, 100);

	public static ToolMaterial toolNetherStar = EnumHelper.addToolMaterial("toolNetherStar", 3, -1, 100.0F,
			46.0F, 1000);

	public static ArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("armorEmerald", 100000,
			new int[] { 5, 10, 8, 6 }, 40);
	
	public static ArmorMaterial armorNetherStar = EnumHelper.addArmorMaterial("armorNetherStar", -1, new int [] { 50, 50, 50, 50 }, 100);

	public static WorldGeneration worldgeneration = new WorldGeneration();

	public static BiomeGenBase BiomeGenOre = new BiomeGenOre();
	
	public static CreativeTabs FTBModifiedCreativeTabs = new FTBModifiedCreativeTabs("FTBModifiedCreativeTabs");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ironBrut = new IronBrut().setUnlocalizedName("ironBrut").setTextureName(MODID + ":ironBrut")
				.setCreativeTab(FTBModifiedCreativeTabs);
		goldBrut = new GoldBrut().setUnlocalizedName("goldBrut").setTextureName(MODID + ":goldBrut")
				.setCreativeTab(FTBModifiedCreativeTabs);
		netherStardust = new NetherStarDust().setUnlocalizedName("netherStardust")
				.setTextureName(MODID + ":netherstardust").setCreativeTab(FTBModifiedCreativeTabs);
		netherStarIngot = new NetherStarIngot().setUnlocalizedName("netherIngot")
				.setTextureName(MODID + ":netheringot").setCreativeTab(FTBModifiedCreativeTabs);
		
		
		emeraldNuggets = new EmeraldNuggets().setUnlocalizedName("emeraldnuggets")
				.setTextureName(MODID + ":emeraldnuggets").setCreativeTab(FTBModifiedCreativeTabs);
		diamondNuggets = new DiamondNuggets().setUnlocalizedName("diamondnuggets")
				.setTextureName(MODID + ":diamondnuggets").setCreativeTab(FTBModifiedCreativeTabs);

		swordemerald = new SwordEmerald(toolEmerald).setUnlocalizedName("swordemerald")
				.setTextureName(MODID + ":swordemerald").setCreativeTab(FTBModifiedCreativeTabs);
		pickaxeemrald = new PickaxeEmerald(toolEmerald).setUnlocalizedName("pickaxeemerald")
				.setTextureName(MODID + ":pickaxeemerald").setCreativeTab(FTBModifiedCreativeTabs);
		axeemerald = new AxeEmerald(toolEmerald).setUnlocalizedName("axeemerald").setTextureName(MODID + ":axeemerald")
				.setCreativeTab(FTBModifiedCreativeTabs);
		shovelemerald = new ShovelEmerald(toolEmerald).setUnlocalizedName("shovelemerald")
				.setTextureName(MODID + ":shovelemerald").setCreativeTab(FTBModifiedCreativeTabs);
		hoeemerald = new HoeEmerald(toolEmerald).setUnlocalizedName("hoeemerald").setTextureName(MODID + ":hoeemerald")
				.setCreativeTab(FTBModifiedCreativeTabs);

		swordstar = new SwordStar(toolNetherStar).setUnlocalizedName("swordnetherstar")
				.setTextureName(MODID + ":sword_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		shovelstar = new ShovelStar(toolNetherStar).setUnlocalizedName("shovelnetherstar")
				.setTextureName(MODID + ":shovel_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		pickaxestar = new PickaxeStar(toolNetherStar).setUnlocalizedName("pickaxenetherstar")
				.setTextureName(MODID + ":pickaxe_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		axestar = new AxeStar(toolNetherStar).setUnlocalizedName("axenetherstar")
				.setTextureName(MODID + ":axe_nether_star").setCreativeTab(FTBModifiedCreativeTabs);

		helmetEmerald = new ArmorEmerald(armorEmerald, 0).setUnlocalizedName("helmetEmerald")
				.setTextureName(MODID + ":helmet_emerald").setCreativeTab(FTBModifiedCreativeTabs);
		chestPlateEmerald = new ArmorEmerald(armorEmerald, 1).setUnlocalizedName("ChestPlateEmerald")
				.setTextureName(MODID + ":chestplate_emerald").setCreativeTab(FTBModifiedCreativeTabs);
		leggingsEmerald = new ArmorEmerald(armorEmerald, 2).setUnlocalizedName("leggingsEmerald")
				.setTextureName(MODID + ":leggings_emerald").setCreativeTab(FTBModifiedCreativeTabs);
		bootsEmerald = new ArmorEmerald(armorEmerald, 3).setUnlocalizedName("bootsEmerald")
				.setTextureName(MODID + ":boots_emerald").setCreativeTab(FTBModifiedCreativeTabs);
		
		helmetNetherStar = new ArmorNetherStar(armorNetherStar, 0).setUnlocalizedName("helmetNetherStar")
				.setTextureName(MODID + ":helmet_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		chestPlateNetherStar = new ArmorNetherStar(armorNetherStar, 1).setUnlocalizedName("chestPlateNetherStar")
				.setTextureName(MODID + ":chestplate_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		leggingsNetherStar = new ArmorNetherStar(armorNetherStar, 2).setUnlocalizedName("leggingsNetherStar")
				.setTextureName(MODID + ":leggings_nether_star").setCreativeTab(FTBModifiedCreativeTabs);
		bootsNetherStar = new ArmorNetherStar(armorNetherStar , 3).setUnlocalizedName("bootsNetherStar")
				.setTextureName(MODID + ":boots_nether_star").setCreativeTab(FTBModifiedCreativeTabs);

		ironBrutblock = new IronOre(Material.rock).setBlockName("IronBrutblock").setHardness(3.0F)
				.setBlockTextureName("ModFTBModified:ironBrutblock").setCreativeTab(FTBModifiedCreativeTabs);
		goldBrutblock = new GoldOre(Material.rock).setBlockName("GoldBrutblock").setHardness(3.0F)
				.setBlockTextureName("ModFTBModified:goldBrutblock").setCreativeTab(FTBModifiedCreativeTabs);
		emeraldBrutblock = new EmeraldOre(Material.rock).setBlockName("EmeraldBrutblock").setHardness(3.0F)
				.setBlockTextureName(MODID + ":emerald_ore").setCreativeTab(FTBModifiedCreativeTabs);
		diamondBrutblock = new DiamondOre(Material.rock).setBlockName("DiamondBrutblock").setHardness(3.0F)
				.setBlockTextureName(MODID + ":diamond_ore").setCreativeTab(FTBModifiedCreativeTabs);
		netherStarOre = new NetherStarOre(Material.iron).setBlockName("Netherstarore").setHardness(3.0F)
				.setBlockTextureName(MODID + ":nether_star_ore").setCreativeTab(FTBModifiedCreativeTabs);
		netherStarBlock = new NetherStarBlock(Material.rock).setBlockName("Netherstarblock").setHardness(3.0F)
				.setBlockTextureName(MODID + ":nether_star_block").setCreativeTab(FTBModifiedCreativeTabs);
		
		GameRegistry.registerItem(ironBrut, "Iron_Brut");
		GameRegistry.registerItem(goldBrut, "Gold_Brut");
		GameRegistry.registerItem(netherStardust, "Nether_Star_Dust");
		GameRegistry.registerItem(emeraldNuggets, "Emerald_Nugget");
		GameRegistry.registerItem(diamondNuggets, "Diamond_Nugget");

		GameRegistry.registerItem(axeemerald, "Axe_Emerald");
		GameRegistry.registerItem(swordemerald, "Sword_Emerald");
		GameRegistry.registerItem(pickaxeemrald, "Pickaxe_Emerald");
		GameRegistry.registerItem(shovelemerald, "Shovel_Emerald");
		GameRegistry.registerItem(hoeemerald, "Hoe_Emerald");

		GameRegistry.registerItem(swordstar, "Sword_Nether_Star");
		GameRegistry.registerItem(pickaxestar, "Pickaxe_Nether_Star");
		GameRegistry.registerItem(shovelstar, "Shovel_Nether_Star");
		GameRegistry.registerItem(axestar, "Axe_Nether_Star");

		GameRegistry.registerItem(helmetEmerald, "Helmet_Emerald");
		GameRegistry.registerItem(chestPlateEmerald, "ChestPlate_Emerald");
		GameRegistry.registerItem(leggingsEmerald, "Leggings_Emerald");
		GameRegistry.registerItem(bootsEmerald, "Boots_Emerald");
		
		GameRegistry.registerItem(helmetNetherStar, "Helmet_NetherStar");
		GameRegistry.registerItem(chestPlateNetherStar, "ChestPlate_NetherStar");
		GameRegistry.registerItem(leggingsNetherStar, "Leggings_NetherStar");
		GameRegistry.registerItem(bootsNetherStar, "Boots_NetherStar");

		GameRegistry.registerBlock(ironBrutblock, "Iron_Brut_Block");
		GameRegistry.registerBlock(goldBrutblock, "Gold_Brut_Block");
		GameRegistry.registerItem(netherStarIngot, "Nether_Ingot");
		GameRegistry.registerBlock(emeraldBrutblock, "Emerald_Brut_Block");
		GameRegistry.registerBlock(diamondBrutblock, "Diamond_Brut_Block");
		GameRegistry.registerBlock(netherStarOre, "Nether_Star_Ore");
		GameRegistry.registerBlock(netherStarBlock, "Nether_Star_Block");

		GameRegistry.registerWorldGenerator(worldgeneration, 0);

		GameRegistry.addSmelting(ironBrut, new ItemStack(Items.iron_ingot), 1.0f);
		GameRegistry.addSmelting(goldBrut, new ItemStack(Items.gold_ingot), 1.0f);
		GameRegistry.addSmelting(netherStardust, new ItemStack(netherStarIngot), 1.0f);


	}

	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRender();

		GameRegistry.addRecipe(new ItemStack(axeemerald),
				new Object[] { "YYY", "YXY", " X ", 'X', Items.stick, 'Y', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(swordemerald),
				new Object[] { " Y ", " Y ", " X ", 'X', Items.stick, 'Y', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(pickaxeemrald),
				new Object[] { "YYY", " X ", " X ", 'X', Items.stick, 'Y', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(shovelemerald),
				new Object[] { " Y ", " X ", " X ", 'X', Items.stick, 'Y', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(hoeemerald),
				new Object[] { "YY ", " X ", " X ", 'X', Items.stick, 'Y', Items.emerald });

		GameRegistry.addRecipe(new ItemStack(swordstar),
				new Object[] { " X ", " X ", " Y ", 'Y', Items.stick, 'X', Items.nether_star });
		GameRegistry.addRecipe(new ItemStack (pickaxestar),
				new Object[] { "XXX", " Y ", " Y ", 'X',Items.nether_star, 'Y', Items.stick});

		GameRegistry.addRecipe(new ItemStack(shovelstar),
				new Object[] { " X ", " Y ", " Y ", 'X', Items.nether_star, 'Y', Items.stick });

		GameRegistry.addRecipe(new ItemStack(helmetEmerald), new Object[] { "XXX", "X X", "   ", 'X', Items.emerald });
		
		GameRegistry.addRecipe(new ItemStack(chestPlateEmerald),
				new Object[] { "X X", "XXX", "XXX", 'X', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(leggingsEmerald),
				new Object[] { "XXX", "X X", "X X", 'X', Items.emerald });
		GameRegistry.addRecipe(new ItemStack(bootsEmerald), new Object[] { "   ", "X X", "X X", 'X', Items.emerald });

		GameRegistry.addRecipe(new ItemStack(Items.emerald), new Object[] { "XXX", "XXX", "XXX", 'X', emeraldNuggets });
		
		GameRegistry.addRecipe(new ItemStack(Items.diamond), new Object[] { "XXX", "XXX", "XXX", 'X', diamondNuggets });
		
		GameRegistry.addRecipe(new ItemStack(Items.nether_star),
				new Object[] { " X ", "XXX", " X ", 'X', netherStarIngot });

		GameRegistry.addRecipe(new ItemStack(netherStarBlock),
				new Object[] { "XXX", "XXX", "XXX", 'X', netherStarIngot });
		GameRegistry.addRecipe(new ItemStack(netherStarIngot, 9),
				new Object[] { "   ", " X ", "   ", 'X', netherStarBlock });
		
		GameRegistry.addRecipe(new ItemStack(helmetNetherStar), new Object[] {"XXX", "X X", "   ", 'X', netherStarIngot});
		GameRegistry.addRecipe(new ItemStack(chestPlateNetherStar), new Object[] {"X X", "XXX", "XXX", 'X', netherStarIngot});
		GameRegistry.addRecipe(new ItemStack(leggingsNetherStar), new Object[] {"X X", "X X", "XXX", 'X', netherStarIngot});
		GameRegistry.addRecipe(new ItemStack(bootsNetherStar), new Object[] {"   ", "X X", "X X", 'X', netherStarIngot});

		BiomeDictionary.registerBiomeType(BiomeGenOre, BiomeDictionary.Type.FOREST);
		BiomeManager.addSpawnBiome(BiomeGenOre);
		BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(BiomeGenOre, 40));

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}
