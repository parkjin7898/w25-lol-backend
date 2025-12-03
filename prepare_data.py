import requests
import json
import os

def fetch_and_transform_champions():
    url = "https://ddragon.leagueoflegends.com/cdn/14.23.1/data/ko_KR/champion.json"
    print(f"Fetching data from {url}...")
    
    try:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()
        
        champions_map = data.get("data", {})
        champions_list = []
        
        print(f"Found {len(champions_map)} champions. Transforming...")
        
        for key, champ in champions_map.items():
            # Add image URL for convenience
            image_filename = champ.get("image", {}).get("full", "")
            image_url = f"https://ddragon.leagueoflegends.com/cdn/14.23.1/img/champion/{image_filename}"
            
            # Create a clean document structure
            champ_doc = {
                "id": champ.get("id"),
                "key": champ.get("key"),
                "name": champ.get("name"),
                "title": champ.get("title"),
                "blurb": champ.get("blurb"),
                "info": champ.get("info"),
                "image": {
                    "full": image_filename,
                    "sprite": champ.get("image", {}).get("sprite"),
                    "group": champ.get("image", {}).get("group"),
                    "x": champ.get("image", {}).get("x"),
                    "y": champ.get("image", {}).get("y"),
                    "w": champ.get("image", {}).get("w"),
                    "h": champ.get("image", {}).get("h"),
                    "url": image_url # Added full URL
                },
                "tags": champ.get("tags"),
                "partype": champ.get("partype"),
                "stats": champ.get("stats")
            }
            champions_list.append(champ_doc)
            
        # Sort by name for easier reading if needed, though MongoDB doesn't care
        champions_list.sort(key=lambda x: x["name"])
        
        output_file = "champions_list.json"
        with open(output_file, "w", encoding="utf-8") as f:
            json.dump(champions_list, f, ensure_ascii=False, indent=2)
            
        print(f"Successfully saved {len(champions_list)} champions to {output_file}")
        print("You can now import this file to MongoDB Atlas.")
        
    except Exception as e:
        print(f"Error occurred: {e}")

if __name__ == "__main__":
    fetch_and_transform_champions()
