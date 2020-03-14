# Day 1 — March 3rd, 2020

After a lot of procrastinating with Blink, another side to this project, I
finally moved on and decided to implement the first iteration of Conway's Game
of Life in JavaScript.

It didn't take long, which was a relief seeing that I'd already frittered away a
large part of the day!

# Day 2 — March 4th, 2020

A much more productive session today. I used Python for this implementation, and
although the finished product isn't nearly as elegant as a more experienced
Pythonista would produce, I can definitely see why so many people love to work
with the language!

I rarely use Python myself, so this turned out to be a nice little challenge.

# Day 3 — March 5th, 2020

Another smooth run today, one more implementation down! Today's implementation
is written in Ruby, and it's a looker.

I feel that Ruby is a bit laborious to write, what with all of its `end`
statements, but aside from that it's a pleasure to use. It feels very much like
Python, and shares a some great syntax bonuses such as `and`/`or`; and ranges
are another hugely useful feature that my go to language JavaScript doesn't
have, so they're _always_ welcome.

# Day 4 — March 6th, 2020

Today was pretty tough, I choose to go with Haskell, and oh my, was it a steep
learning curve.

A few years ago I read a great introductory book on Haskell (that I couldn't
recommend more) called "Learn You a Haskel for Great Good". At the time I felt
as though I was getting a grasp on the syntax and language structure in general,
but I failed to put those learnings into practice, and between then and now, it
looks as though I'd managed to forget _everything_.

# Day 5 — March 7th, 2020

A very entertaining implementation today using just vanilla POSIX shell! This
meant no access to arrays or Bashisms, and therefore a much more challenging
task in general.

# Day 6 — March 8th, 2020

Another day, another implementation. I decided to Go with Go today (best pun I
could think up, sorry) as per a suggestion from someone on Twitter. I'm not
hugely happy with the look of the code at the moment, but I'm glad that it's
working for now!

I'd never realised just how much Go looks like JavaScript, I'm not sure if this
was a conscious design choice or not? I'm not complaining, I love good'ol
JavaScript, any similarities are welcome from my perspective.

I will say this, although Go isn't a functional language, I'm pretty surprised
that it lacks basic instance methods for iterating over arrays, aside from
for/while loops of course. I'm not sure if I've missed something from the
documentation perhaps?

# Day 7 — March 9th, 2020

The first week is complete! I chose to go with Groovy today, not a language that
I often use (outside of Jenkins of course), but the language shares a lot of
semantic similarities with JavaScript, so it sits well under my fingers.

I went for a semi-functional approach, not something Groovy is normally used
for, but seeing that I'd not normally be allowed to write "functional" Groovy, I
thought I'd go ahead a treat myself.

# Day 8 — March 10th, 2020

Today's implementation of Conway's Game of Life is written using Rust. I like
Rust, a lot, I like the idea of it, I love the tooling behind it, and for a
modern competetor to C/C++, it's hit the nail on the head in my opinion.

I've read mixed reviews about Rust from diehard C programmers, they sometimes
ring little alarm bells in my head, but you've got to take these with a pinch of
salt.

People shouldn't brush over the fact that the ongoing development of Rust is
pushing forward not one, but two fronts, with system level programing and WASM
benefitting from the efforts of the team behind it.

# Day 9 — March 11th, 2020

I have to start by saying that this was one of the best implementations so far.
Racket is a pleasure to write! I have a soft spot for languages that look good
on the screen, and Racket looks great.

I've not used any fancy macros or features from the many extensions of Racket
(or are they different schemes entirely?), so I like to think that this is a
relatively vanilla approach. I'd appreciate feedback if anybody has any!

Before I sign off, I came across [this wonderful website][9.1] full of tips and
tricks on how to write tip-top Racket.

[9.1]: https://beautifulracket.com/

# Day 10 — March 12th, 2020

Today was a really tough one, for a number of reasons, the biggest of which I'll
explain now. TLDR; I chose Dart.

The core instance methods in Dart feel erratically implemented. Take the List
class as an example, on the one hand there are ten methods dedicated to the
removal and insertion of elements. Ten! Yet on the other hand, there's only one
way to map over a List, and you don't have access to the List indices whilst
doing so.

If, like me, you'd like to map over a List in Dart with access to the indices,
you'll have to convert the List to a Map, iterate over that Map, returning a
MapEntry for each element, retrieve the values as an Iterable from the Map, and
then cast that Iterable back to a List. Phew!

I was also surprised to find out that some core classes such as Map, can't be
extended... In an object-oriented programming language where everything is an
Object, I found that extremely jarring.

In all honesty, I just struggled to get behind the language. It's not to say
that it's all doom and gloom, the type system feels mature and there _are_ some
nice features in the language, such as extensions. It's just unfortunate that
these positives are heavily outweighed by the negatives.

# Day 11 — March 13th, 2020

Such an improvement on yesterday, today I went ahead with an implementation in
[Lua][11.1]. Special thanks goes out to those that voted for Lua on my short
Twitter poll the other day!

I've already created [a ticket][11.2] on GitHub to revisit this implementation
in the future (I'd really like to experiment with `goto` statements in Lua).

[11.1]: https://github.com/iainreid820/game-of-life/blob/master/lua/main.lua
[11.2]: https://github.com/iainreid820/game-of-life/issues/1

# Day 12 — March 14th, 2020

For today's implementation I grabbed a cup of coffee and cracked on with some
[Java][12.1]. This was a rather vanilla implementation, nothing too fancy,
nothing too spicy.

I've worked as a Scala developer in the past, and without all of that functional
goodness lending me a helpful hand, I had to do a little searching for more
object-orientated solutions in Java. I'm pleased with the resulting
implementation, but I sincerely apologise if you're a purist Java developer and
you feel slightly queasy whilst reading through the implementation.

[12.1]: https://github.com/iainreid820/game-of-life/blob/master/java/main.java
