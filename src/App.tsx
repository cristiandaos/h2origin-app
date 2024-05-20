
import Navbar from "./Navbar";
import Hero from "./Components/Hero";
import SignUp from "./Components/SignUp";
import LogIn from "./Components/LogIn";


function App() {

  return (
    <div className=" bg-white">
      <Navbar/>
      <Hero/>
      <LogIn/> 
      <SignUp/>
    </div>
  );
}

export default App;
