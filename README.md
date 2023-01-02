# soccerHTMX

The soccer app in HTMX. For now no deployment in a public cloud. Need to read some books first to get this running.
It uses Spring Boot + Thymeleaf. This seems to be an environment some people are happy with.

Build it with `./gradlew build`, run it with `./gradlew bootRun`.
Enjoy it at `http://localhost:8080`

If I have some time left
- Add deployment
- Add nicer styles and fonts
- Maybe enhance element swapping (for now the whole list is swapped)
  - Manual react so to say


## Notes

- DX is horrible
  - Restart application on every change. Yes this seems to solvable. But why do I need to solve it?
  - Turnaround is no fun
  - Getting started thus feels slow to me
- Getting started for this combination is less than optimal
  - Missing docs
  - Missing getting started
  - There are some helper projects. I cannot say if they help me. :shrug:
- How do you test this?
  - Fire up Spring Boot and some Docker stuff for a single function?
- SASS Support
  - How do I achieve this (easily)?
- I miss components
  - As a way to structure my ui code
  - Fragments are nice but just don't cut it.
- How do I go about with assets like fonts?
  - Simple one, I just don't know it.
  - In JS Land everything already comes along with nice fonts.
- Warnings in thymeleaf regarding HTMX templates.
  - I thought/hoped that this would be adressed by the plugin used. What do I miss here?
- Swapping elements on the basis of IDs or UI structure in conjuction with Thymeleaf fragments seems a little brittle to me.
  - I had some problems/bugs with that
  - You have to have the UI-structure in mind when swapping elements. There seems to be very little support for references, it's just strings.
  - See "I miss components"
- Debugging layout fuckups, because sth got replaced somehow wrong is a little painful
  - Look at the rendered output and guess what could have gone wrong.
- I think HTMX does the job kinda, my criticism is mostly targeted towards the Spring-Boot integration.
  - There are many pieces missing that are a staple in the JS Ecosystem
  - If you are integrating HTMX with sth different, many of the above points could be solved
    - Phoenix/Rails etc.
- That being said: I could get sth done in a surprising short amount of time.
  - Given I start with Spring Boot from - not zero -
- And tbh it's quite astonishing to me, how much you can achieve without a single line of JS.
  - But that comes at a price:
    - You still have to know what you are doing
    - All the comfy JS-stuff for testing/debugging/turnaround is gone
    - It's all reference by string, little linting/compiling
    - You will stare at your markup a lot
- Current verdict:
  - This might be sth if
    - You just want to build sth with very little client side logic.
    - With very little styling requirements
    - If you really despise JS. 
      - If your main goal is server side rendering, then Next or Remix seem to be the more capable option
      - But if you are into the Anti-JS-Movement: Go for it!
    - If your team has no JS ambitions/knowledge