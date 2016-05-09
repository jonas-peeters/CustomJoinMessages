# Custom Join Messages
Change the standard Bukkit join and leave messages to a colourful, custom message and differentiate between normal players and operators

# Usage
1. Copy the 'CustomJoinMessages.jar' into your server's plugin folder
2. Create in the main folder of you server the 'cjmconfig.txt'

# cjmconfig.txt Setup
This file must be placed into the main directory of your server

!!The following file setup is required!!
1. Line: `Messages:`

2. Line: `PLACEHOLDER` <- Join-Message for normal players

3. Line: `PLACEHOLDER` <- Join-Message for operators

4. Line: `PLACEHOLDER` <- Leave-Message for normal players

5. Line: `PLACEHOLDER` <- Leave-Message for operators


# Message Setup
`PLAYER` will be replaced with the name of the player

`PLAYERCOUNT` will be replaced with the number of players

These are optional. For a blank message leave the line blank

# Color Codes

`Aqua:		    §b`
`Blue:		    §9`
`Gold: 		    §6`
`Green:		    §a`
`Yellow:		§e`
`Red: 		    §c`
`Light Purple:  §d`
`Dark Aqua:	    §3`
`Dark Blue:	    §1`
`Dark Green:	§2`
`Dark Red:	    §4`
`Dark Purple:   §5`
`White:		    §f`
`Gray:		    §7`
`Dark Gray:	    §8`
`Black:		    §0`

# Other Codes

`Bold: §l`
`Italic: §o`
`Underline: §n`
`Strike: §m`
`Reset: §r`
`Random Chars that change: §k`

# Examples

Minigame join message: `§2PLAYER §a joined the game [§8PLAYERCOUNT§a]`

Admin join message: `§4[OP] PLAYER joined the server`