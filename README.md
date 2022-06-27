# Disable Portals
A simple mod that allows for the disabling of nether portals
and end portals. It adds the `disableportals` command for all
operators.

<br>

![screenshot example][Ex disableEndPortals]
![screenshot example][Ex disableEndGateways]

## Command Usage
`disableportals reloadConfig` - reloads the config file, 
located in `config/DisablePortals.json`

`disableportals (netherAllowed|endAllowed|endGatewaysAllowed)
(true|false)` - sets the selected dimension's portals to work
or not to work.Ex: `disableportals endAllowed false` will
turn off end portals.


## Config Usage
A config file (`config/DisablePortals.json`) will auto 
generate and look like this

![config file screenshot][Config]

By default, no portals are disabled. To disable nether
portals through the config, set `disableNetherPortals` to 
true. If you make changes to the config while the game is
running, you will have to run `disableportals reloadConfig`
for the changes to take effect.

<br>

<!-- Badges -->
[![Fabric API Badge][Fabric API Badge]][Fabric API Download]
[![Join the Discord for support][Discord Badge]][Discord Invite]


<!-- Image URLs -->
[Ex disableEndPortals]: https://media.discordapp.net/attachments/819612740736778291/819730605943554048/unknown.png
[Ex disableEndGateways]: https://media.discordapp.net/attachments/819612740736778291/819735337240363028/image-1.png4.png
[Config]: https://media.discordapp.net/attachments/819612740736778291/819655485379837992/unknown.png

[Fabric API Badge]: https://i.imgur.com/HabVZJR.png
[Discord Badge]: https://discord.com/assets/cb48d2a8d4991281d7a6a95d2f58195e.svg

<!-- Hyperlink URLs -->
[Fabric API Download]: https://modrinth.com/mod/fabric-api 
