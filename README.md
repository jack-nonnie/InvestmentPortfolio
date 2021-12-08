# InvestmentPortfolio
Things accomplished:
1. Set up Spring framework
2. Set up class for Stocks and Portfolio
3. Set up a Servelt for the portfolio page and for the stock search page
4. Set up the api so that we are able to get live prices for stocks
5. Set up the api so that we can find various information about stocks
6. Created a search function to search for information about stocks
7. Redesigned the Portfolio
8. Made the trading stocks page work better behind the scenes
9. Set up class for positions
10. Desmelled/refractored a lot of the code
11. Debugged and tested possible error end cases
12. Created an error page that dynamically updates based off of different types of errors
13. Added a second API call on the search so that one can get the current price of a stock

Investment Portfolio Simulator

Design an interface that will simulate an investment portfolio. The user can buy and sell various types of financial instruments and be able to view the current state of their portfolio. Additionally, before buying or selling something, the user should be able to look up key information about the instrument. Such as:

Security Stock (price, dividend, yield) Bond/fixed income (price, coupon, yield, expdate) Cash (interest) Municipal bond (price, coupon, yield, expdate, taxation?) Treasury Bond You can decide as part your design which types of instruments you want to support (minimum three types of instruments).

Mimimal Requirements The simulation must allow the user to do the following:

Add / withdraw cash balance Buy and sell securities as long as the user has sufficient balance See their current position (the quantity of each security) See their current portolio value (the total worth of all their holdings) Search for and view information about prospective instuments before buying Save the state of the portfolio so that the user can restart the program and not lose their data Additional Features Additional features you may want to consider:

Displaying useful information as graphs Display Real-time price information

Project Plan Key Components: There will be three main UI components for this project: Public dashboard (list of all stocks/bonds) Personal portfolio Trading Weekly milestones: 1 of 4: Finalize which frameworks we will be using for the UI and database Complete first draft of outline of the project Potentially add a figma for the UI Some pseudocode and file/project structure 2 of 4: Complete first iteration for project 3 of the 4 Instruments are implemented Capable of Adding and Withdrawing Cash Able to view portfolio along with positions and value Search for different securities is possible Prepare for integration 3 of 4: All member’s parts work together as intended Code is cleaned up and unit tested and bugs fixed Save portfolio data on command Implement additional information for securities Potentially allow real time data Potentially display information in graph form 4 of 4 Complete rigorous testing and fix any remaining bugs All features working as intended

Assumptions: No login system, only one user for the application (could be an additional feature)

Work Allocation: There are three main components for the project, each member will start working on one of the three mentioned at the top of this plan. Not all may be of the same complexity so assistance in other areas may be assigned.
