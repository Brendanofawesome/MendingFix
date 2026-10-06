# MendingFix
Fabric mod designed to fix the bug (MC-176559) where a pickaxe with mending will reset mining progress when durability is repaired

This mod replaces the call to ItemStack.matches(currentItem, originalItem) with ItemStack.matchesIgnoringComponents(currentItem, originalItem, type -> type == DataComponents.DAMAGE)), ensuring that a change in item damage does not reset mining progress.

## Development

This is a Fabric Loom Gradle project targeting Minecraft 26.3 (the version identifier
used by Fabric for Minecraft 1.26.3) and Java 25. It uses Fabric Loader directly and
does not depend on Fabric API.

```powershell
.\gradlew.bat build
.\gradlew.bat runClient
```

The built mod jar is written to `build/libs/`.
