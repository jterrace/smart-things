def body = """fanspd<fanspd>7</fanspd>
doorinprocess<doorinprocess>0</doorinprocess>
timeremaining<timeremaining>0</timeremaining>
macaddr<macaddr>60:CB:FB:00:12:A3</macaddr>
ipaddr<ipaddr>192.168.1.6</ipaddr>
model<model>3.5eWHF</model>
softver: <softver>2.15.1</softver>
interlock1: <interlock1>0</interlock1>
interlock2: <interlock2>0</interlock2>
cfm: <cfm>8687</cfm>
power: <power>147</power>
inside: <house_temp>-99</house_temp>
<DNS1>192.168.1.1</DNS1>
attic: <attic_temp>133</attic_temp>
OA: <oa_temp>-99</oa_temp>
server response: <server_response>XÿvÏ‰dõ†ß
-“^¼0>°ü</server_response>
DIP Switches: <DIPS>11100</DIPS>
Remote Switch: <switch2>1111</switch2>
Setpoint:<Setpoint>0</Setpoint>
"""

def regex = ~/(.*)<[^\/]/
// def regex = ~/.*/
def matcher = body =~ regex
body = body.replaceAll(regex){all, prefix ->
  return all.replace(prefix, "")
}
body = "<response>${body}</response>"
println body
