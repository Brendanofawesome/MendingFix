# MendingFix
Fabric mod designed to fix the bug (MC-176559) where a pickaxe with mending will reset mining progress when durability is repaired

## Setup  

For Fabric setup instructions, please see the [Fabric Documentation page](https://docs.fabricmc.net/players/installing-fabric/).

## Technical  

This mod replaces the call to ItemStack.matches(currentItem, originalItem) with ItemStack.matchesIgnoringComponents(currentItem, originalItem, type -> type == DataComponents.DAMAGE)), ensuring that a change in item damage does not reset mining progress.
