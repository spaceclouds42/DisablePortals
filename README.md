# Disable Portals
A simple mod that allows for the disabling of nether portals
and end portals. It adds the `disableportals` command for all
operators.

### Command Usage
`disableportals reloadConfig` - reloads the config file, 
located in `config/DisablePortals.json`

`disableportals (netherAllowed|endAllowed) (true|false)` - 
sets the selected dimension's portals to work or not to work.
Ex: `disableportals endAllowed false` will turn off end 
portals.

### Config Usage
Your config should auto generate and look like this

![config file screenshot](https://media.discordapp.net/attachments/819612740736778291/819655485379837992/unknown.png)

By default, no portals are disabled. To disable nether
portals through the config, set `disableNetherPortals` to 
true. If you make changes to the config while the game is
running, you will have to run `disableportals reloadConfig`

<a href="https://modrinth.com/mod/fabric-api">
    <img width="200" alt="Requires Fabric API" src="https://i.imgur.com/HabVZJR.png">
</a>
<a href="https://discord.gg/D7TjNrArMw">
    <img width="200" alt="Join the Discord for support" src="https://discord.com/assets/bb408e0343ddedc0967f246f7e89cebf.svg">
</a>
