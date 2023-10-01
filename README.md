# LimboAPI
## Features of LimboAPI

- Send to the Limbo server during login process
- Send to the Limbo server during play process
- Send maps, items to player's virtual inventory
- Display player's XP
- Send Title, Chat, ActionBar
- Load world from world files like .schematic
- and more...

## How to

- Include ``limboapi-api`` to your Maven/Gradle project as compile-only
- Subscribe to ``LoginLimboRegisterEvent`` to send players to the Limbo server during login process
- Use ``LimboFactory`` to send players to the Limbo server during play process

## Used Open Source projects

- [ProtocolSupport](https://github.com/ProtocolSupport/ProtocolSupport) - for modern->legacy block mappings
- [ViaVersion](https://github.com/ViaVersion/ViaVersion) - for modern string->integer block mappings


### Original Creator
https://github.com/Elytrium/LimboAPI