Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight 
When the time is 00:00:00 and format is H[H]:mm:ss
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Midnight  
When the time is 00:00:00 AM and format is h[h]:mm:ss a
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Just after Midnight
When the time is 00:01:01 and format is H[H]:mm:ss
Then the clock should look like
O
OOOO
OOOO
OOOOOOOOOOO
YOOO

Scenario: Just after Midnight
When the time is 00:01:01 AM and format is h[h]:mm:ss a
Then the clock should look like
O
OOOO
OOOO
OOOOOOOOOOO
YOOO

Scenario: An Hour after Midnight
When the time is 01:01:01 and format is H[H]:mm:ss
Then the clock should look like
O
OOOO
ROOO
OOOOOOOOOOO
YOOO

Scenario: An Hour after Midnight
When the time is 01:01:01 AM and format is h[h]:mm:ss a
Then the clock should look like
O
OOOO
ROOO
OOOOOOOOOOO
YOOO

Scenario: Early Morning
When the time is 06:30:19 and format is H[H]:mm:ss
Then the clock should look like
O
ROOO
ROOO
YYRYYROOOOO
OOOO

Scenario: Early Morning
When the time is 06:30:19 AM and format is h[h]:mm:ss a
Then the clock should look like
O
ROOO
ROOO
YYRYYROOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01 and format is H[H]:mm:ss
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Middle of the afternoon
When the time is 01:17:01 PM and format is h[h]:mm:ss a
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: At afternoon
When the time is 12:00:00 and format is H[H]:mm:ss
Then the clock should look like
Y
RROO
RROO
OOOOOOOOOOO
OOOO

Scenario: At afternoon
When the time is 12:00:00 PM and format is h[h]:mm:ss a
Then the clock should look like
Y
RROO
RROO
OOOOOOOOOOO
OOOO

Scenario: Around  evening
When the time is 17:17:01 and format is H[H]:mm:ss
Then the clock should look like
O
RRRO
RROO
YYROOOOOOOO
YYOO

Scenario: Around  evening
When the time is 05:17:01 PM and format is h[h]:mm:ss a
Then the clock should look like
O
RRRO
RROO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59 and format is H[H]:mm:ss
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Just before midnight
When the time is 11:59:59 PM and format is h[h]:mm:ss a
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY


Scenario: Midnight
When the time is 24:00:00 and format is H[H]:mm:ss
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Midnight
When the time is 12:00:00 AM and format is h[h]:mm:ss a
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO












