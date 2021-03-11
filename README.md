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
