<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registered Users</title>
    <link rel="icon" href="assets/image/logo1.png" />
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="login.css" />
    <link rel="stylesheet" href="recruiter.css" />
                 <style>
     <%@ include file="css/style.css"%>
       <%@ include file="css/login.css"%>
       <%@ include file="css/user-profile.css"%>
        <%@ include file="css/recruiter.css"%>
  
</style>
    
    <style>
      .nav-links > a:nth-child(2) {
        color: blue;
      }
      .h_main {
        margin-bottom: 100px;
      }
      .nav-links {
        flex-basis: 33%;
      }
      .login_register_links {
        flex-basis: 15%;
      }
      .login_register_links > h3 {
        font-size: 20px;
        color: #000;
      }
      .act {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;
      }
      .act > a {
        display: flex;
        align-items: center;
      }
      .act > a > svg {
        width: 50px;
        display: flex;
        align-items: center;
        margin-top: 15px;
        margin-left: 20px;
      }
      body {
        background: linear-gradient(
          180deg,
          #fff5f5 0%,
          #c0fcf9 49%,
          #a1fbf5 75%,
          #82f9f2 100%
        );
      }
      .h_main {
        padding: 0 75px;
      }
      .del-row {
        display: flex;
        align-items: center;
        justify-content: space-between;
      }
      .del-row > a ,     .a_inner_sec > a{
        width: 50px;
        height: 50px;
        border-radius: 50%;

        display: flex;
        align-items: center;
        justify-content: center;
        box-shadow: 0px 4px 6px 2px rgba(255, 54, 54, 1);
      }
      .c2{
        align-items: center;
    
      }
      .a_inner_sec >a{
        margin-top: 10px;
      }
    </style>
     <style>
        /* Styling the container */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Styling the dropdown menu */
        .dropdown-menu {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;

        }

        /* Each menu option */
        .dropdown-menu a {
            color: black;
            text-decoration: none;
            display: block;
            padding: 8px 16px;
        
        }

        /* Hover effects */
        .dropdown-menu a:hover {
            background-color: #ddd;
        }

        /* Show dropdown when hovering */
        .dropdown:hover .dropdown-menu {
            display: block;
        }

        /* Styling the button */
       

      
    </style>
  </head>
  <body>
    <nav>
      <a href="admin-registered-users">
        <svg
          width="67"
          height="65"
          viewBox="0 0 67 65"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
          xmlns:xlink="http://www.w3.org/1999/xlink"
        >
          <rect width="66.7568" height="65" fill="url(#pattern0_41_2)" />
          <defs>
            <pattern
              id="pattern0_41_2"
              patternContentUnits="objectBoundingBox"
              width="1"
              height="1"
            >
              <use
                xlink:href="#image0_41_2"
                transform="scale(0.00526316 0.00540541)"
              />
            </pattern>
            <image
              id="image0_41_2"
              width="190"
              height="185"
              preserveAspectRatio="none"
              xlink:href="data:image/png;base64,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"
            />
          </defs>
        </svg>
      </a>
      <div class="nav-links">
        <a href="registered-companies">Companies Detail</a>
        <a href="admin-registered-users">User Detail</a>
        <a href="">Report</a>
      </div>
      
     
      <div class="login_register_links -n dropdown">
        <h3 class="dropdown-button">Welcome , Admin</h3>
         <div class="dropdown-menu">
            <a href="logout">Logout</a>
        </div>
      </div>
    </nav>
    <h2>Registered Users</h2>
    <main class="h_main">
    
    
            <c:forEach var="e" items="${users}">
     
		
      <div class="jobs_cart -jap">

        <div class="a_sec">
          <div class="a_sec_1">
            <img src="assets/image/profile.png" alt="" />
            <div class="a_inner_sec">
              <h3>${e.full_name }</h3>
              <p>
                <svg
                  width="25"
                  height="25"
                  viewBox="0 0 25 25"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                >
                  <rect width="25" height="25" fill="url(#pattern0_29_11)" />
                  <defs>
                    <pattern
                      id="pattern0_29_11"
                      patternContentUnits="objectBoundingBox"
                      width="1"
                      height="1"
                    >
                      <use
                        xlink:href="#image0_29_11"
                        transform="scale(0.0111111)"
                      />
                    </pattern>
                    <image
                      id="image0_29_11"
                      width="90"
                      height="90"
                      preserveAspectRatio="none"
                      xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAYAAAA4qEECAAAAAXNSR0IArs4c6QAABT5JREFUeF7tnE2I5EQUx9+LH6OI4ldaD4KCevAki4LgRS/u6vqFYq+we1CZZelUGmfEAT3mqCguupN077AzjqgXhxVcv1Y96E38AGEPngT1IIgtepBuukN3yinJyGzTSVV3J6+T6de3Jan61/vln0rln5pF4B8JASRRYRFg0EQmYNAMmogAkQw7mkETESCSYUczaCICRDLsaAZNRIBIhh3NoIkIEMmwoxk0EQEiGXY0gyYiQCTDji4C6OXl5SvDMPwYAO4mGk9ZZb7v9/sPrK2t/ZlUgNbRKysrl3U6nfcBYH9ZKeQ5binlV71e75GNjY1/0nS0oFXjarV6sW3b7wLAE3kOuoR9f9jpdA5tbm52dWMfBq3+LUc1qlarF9i2fQoAntZ1Og/HEfEt27aPep7XT6j3PJbngRZCvF2pVJ5JayyEeAUAnp8HmInzLaJv2/aznudFKaY8GQTB0Z3jw6CVm7W3g+M4LyDiS/MIGxFf9n3/xaTad0+zQRD8z3cUaDCZ4IUQAgBOAIA1J8CllHKl0Wi8llTv8MJBCzruSLtkcRznMCJuAsBFexz2ABGP+b6/kVSn4zhXIeJHu5fCpqABEX8cDAb7m83mb0kCrus+JKV8DwAu3aOwe5ZlHVldXT2dVJ8Q4nop5VlEvH33Ocag40a/AMB9QRD8lHI170HEMwBwxR6D3UbEx3zf/yKprlqtdpNlWer4LcPnjAtatf9dSnmg0WicS4F9ByKeBYBr9wjsvxHxQd/3v05x8m3bU8XnAHDDqHMmAa36mVq4RBdAa6x6vX5nFEWfphlrUtCKUxsAHg+CQF3Fkb/4VlLHby0R2N1D1U6V9Xr93iiKPtBNldOAVg/IEBEPpz0clpaWrgvD8LPhh0PRwZs8/IUQDwOAevhfoqtnKtBx59rlTgmTv+/6/f7BtAROCHEEAN40Xc5mAVrxNlrAt9vt04h4QHf1Z3nc5AXNcRwXEd8Y5wUtK9D/sRnnlXSWMFO0c4scMgUdwzYKWQBgsWCw38kzRMscdAwv10FnfYHQMIGbxhx5gVYscrsNswRNNd3lCbroyZ/RAzyrT3e5go6dV8TkT7skHZXATXMnUYAuWvI3cQJXeNDxALWvs47j5J38TZXAlQW0Gqc2oHEcJ6/kb6ZBGMnUMeSEWRSsvcAmCVyZHL0zVm3y57rujVJKFaJPm/z9rDb8pH2sME3gygiaJPnLOoErJWiC5C/zBK7MoPNK/r7sdruPpu2BmySBKzvoTJM/9WG43W4/mbYHbhabfmax6kgzxutBEDyXtuevUqkEUspjCZ2cbLVa7tbW1iDhOAohjm9/81yaxp2TtC0aaPWQ1G0YhPgTUh0A9sVF/4CIJ3zfV5tWRv48z7uw1WqdklI+NQmoadsUDnRckDb5G6fwImw1Lipoo+TPBHZRNs8XFnQM8Zter3dwfX39LxOow+csLi5evbCw8AkA3DVJ+yzbFB20qvXXKIoONZvNb8cpvFar7UPELUS8eZx2eZ1bBtCq9q6U8tUwDI/r3O267jVSSrVyURvktfst8gI73G9ZQO+MW/0Rzhm1W3N7l9Q5RPwjfuOpWJaldm/eL6VUm1oupwJoqlM20KZ1Fe48Bk10SRg0gyYiQCTDjmbQRASIZNjRDJqIAJEMO5pBExEgkmFHM2giAkQy7GgGTUSASIYdPWvQRPpzKWP0n1fNJZmMi2bQGQNN6o5BM2giAkQy7GgGTUSASIYdzaCJCBDJsKMZNBEBIhl2NIMmIkAkw45m0EQEiGTY0QyaiACRDDuaCPS/RA4jiFhwEj0AAAAASUVORK5CYII="
                    />
                  </defs>
                </svg>
               ${e.email }
              </p>
              <p>
                <svg
                  width="25"
                  height="25"
                  viewBox="0 0 25 25"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                  xmlns:xlink="http://www.w3.org/1999/xlink"
                >
                  <rect width="25" height="25" fill="url(#pattern0_29_13)" />
                  <defs>
                    <pattern
                      id="pattern0_29_13"
                      patternContentUnits="objectBoundingBox"
                      width="1"
                      height="1"
                    >
                      <use
                        xlink:href="#image0_29_13"
                        transform="scale(0.0111111)"
                      />
                    </pattern>
                    <image
                      id="image0_29_13"
                      width="90"
                      height="90"
                      preserveAspectRatio="none"
                      xlink:href="data:image/png;base64,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"
                    />
                  </defs>
                </svg>

               ${e.mobile }
              </p>
            </div>
          </div>
          <div class="a_sec_1">
            
            <div class="a_inner_sec c2">
                <button>Resume/Document</button>

                <a href="delete-user?u_id=${e.u_id }">
                    <svg
                    width="35"
                    height="35"
                    viewBox="0 0 35 35"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink"
                  >
                    <rect width="35" height="35" fill="url(#pattern0_174_208)" />
                    <defs>
                      <pattern
                        id="pattern0_174_208"
                        patternContentUnits="objectBoundingBox"
                        width="1"
                        height="1"
                      >
                        <use
                          xlink:href="#image0_174_208"
                          transform="scale(0.0111111)"
                        />
                      </pattern>
                      <image
                        id="image0_174_208"
                        width="90"
                        height="90"
                        preserveAspectRatio="none"
                        xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAYAAAA4qEECAAAAAXNSR0IArs4c6QAABTJJREFUeF7tnL9vHEUUx7+z5oeMbAINFTLkD7AQBTIChyKF72ZiSzTXOFBDAkgQhHBSwJEC80P8FsHU2FBYouFu3toNFgEkU1AEaqQIUVDhwAkDyfmRlc5IWEZx9t6b2zlm29v5vu989ml39r25NUhHEAImSJQUBAl0oCRIoBPoQAQChUkZnUAHIhAoTFQZPTMzczjLsocLNlmWfeq9vxiIU99hogFdq9WOZFnmAYz1Zt0BUCeir/qmEEAgGtDW2m8A3LeHySYR3R+AU98hYgL9J4Cb9sz4LyK6uW8KAQRiAs378SCiKOagatJa+6Ax5k1mvhfAjQESp0yIywC+BfCs5v1eDbRz7i5m/g7AeJnZD2DMb8aYSa2VjCboU8z8xgCA9RPyGSJ6ux+B/xrbF+i5ublbut3u68x8HMAhDYMV0Nxi5pXx8fHnVldXt8v66Qu0c26JmR8rGzymccaYD733j5f1XBp0s9nMNjc3i5eG0bLBIxv3+9TU1Hiz2dwp4zuBPji1wYAu/P2fbh0AlojoxMGvy7/PLJ3RhUyj0RjtdDqvAXgEwG1lTVR83C8AlsfGxp4f2MOw4oAqZa+vjK7UTCpuJoEOdIES6AQ6EIFAYVJGxwbaWrs1hPWOS1eLTCLLVrGMttZeADAZKEFChblARPdIBBMD7ZxrMfMxCVMV0mgR0ZyEHzHQ1tpzAEq/okpMRlrDGHPOe/+EhK4YaOfcaWZ+WcJUVTSY+XSe569I+BEDba0tiv/LEqaqomGMOe69/1jCjxjo3gaXLyRMVUWDmY/kef6lhB8x0LOzsxPdbjeaLVoHgdftdifW19d/PMi51zpHDHSj0RjpdDp/ALjhWkEj+f3K9vb26MbGxhUJv2KgCzPW2iKjJySMVUDjIhHdLeVDGvR5ANNS5gapY4w5771/SMqDNOgVAPNS5gass0JERedI5BAF7ZxbZOYFEWcDFmHmxTzPz0jZEAVdr9dPGmPelzI3YJ2TRPSBlAdR0M65WWb+TMrcIHV2dnZm19bW2lIepEFPMnNRxYv+yLJsst1ufy81EVHQ1tpbAVySMjdgnUNE9KuUB1HQvbX0MDQAtojodinIhY4G6GFoAIgV/HcvljjoIWkAiBX81UAPQwNAsuCvBnoYGgCSBX810MPQAJAs+KuBrtfr00VBRvKJPQCtael/aIk/DIehASBZ8FfL6CFoAIgW/NVA915aYm4AiBb8tUFH2wCQLvhrg465ASBa8FcFHXMDQLrgrwraWltsDSu2iEV3GGNOeO+XpI2LL+8Kg7Va7ViWZS1psyH0io2aeZ4XX7oRPVRAO+eibQBIF/y1bx0xNwBEC/6qoCNuAIgX/EOAjrEBIF7wVwcdaQNAvOCvDjrGBoBGwV8ddL1eXzDGLIqukfTFFojoVY0wKsu7wqhzbr74RI6GaS1NZp7P8/wTDX010JE2AMQL/uq3jhgbABoFf3XQETYAVAr+6qB7Ly0xNQBUCv6hQEfTANAq+AcB7Zz7iJnFds1rrAb+AWHMsvf+Ua0YaquO3hIvms9mMvOpPM/fihK0tfZOAD9U+Eu7u1wvj4yMHG61Wj9FCbr3QHwJwAtaExDSfZGIzgpp7SujeusoIvY+rfkOgCc1J1JW2xjzrvf+aQD7fgi8rO7eceqgdwNaa48CeArAA1f7iXdITaCkzs8Avs6y7L12u/15SY3rGhYM9HW5GsKTE+hAFzWBTqADEQgUJmV0Ah2IQKAwKaMT6EAEAoVJGZ1AByIQKEzK6AQ6EIFAYf4GlrXfarBQmYYAAAAASUVORK5CYII="
                      />
                    </defs>
                  </svg>
                </a>
        
            </div>
          </div>
        </div>
        <small>${e.created_date }</small>
      </div>
   
   	</c:forEach>
    </main>
  </body>
</html>
